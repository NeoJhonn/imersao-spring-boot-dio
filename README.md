# Spring Boot Framework

- Starters: são decritores de dependência, reúne conjunto de dependências mínimas para um projeto, para o desenvolvedor focar no
  negócio.

- Spring-boot-starter:
  - data-jpa: JPA - Hibernate
  - data-mongodb
  - web: container Tomcat aplicações REST
  - web-service: arquitetura SOAP
  - batch: JOBs de processo
  - test: JUnit
  - openfeign: Cliente HTTP em interfaces para consumo de APIs
  - actuator: gerenciamento de monitoramento da aplicação

## Configurando um projeto Spring Boot

- Criar um projeto no https://start.spring.io/

## Interface CommandLineRunner

- O @Component que implementar a interface CommandLineRunner será execultado quando a aplicação Spring Boot for inicializada:

```
@Component
public class MyApp implements CommandLineRunner {

    @Autowired
    Calculator calculator;

    @Override
    public void run(String... args) throws Exception {
	// Aqui você pode criar toda uma lógica para rodar uma aplicação em console
        System.out.println("Soma: "+ calculator.sum(2, 30));
    }
}
```

## Singleton vs Prototype

- Singleton: um único objeto sendo utilizado a cada necessidade da aplicação.

- Prototype: a cada necessidade da aplicação tera uma nova instância a essa nova necessidade. Para que o Spring gerêncie isso e crie
  uma nova referência a cada novo uso adicione e notação @Scope junto com @Bean ao objeto:

```
@Configuration
public class Beans {

    @Bean
    @Scope("prototype")
    public Remetente remetente() {
        System.out.println("Criando um objeto Remetente");
        Remetente remetente = new Remetente();
        remetente.setEmail("noreply@dio.com.br");

        return remetente;
    }
}

// Assim o Spring não vai se perder nas referências
@Component
public class SistemaMensagem {

    @Autowired
    private Remetente noreply;

    @Autowired
    private Remetente techTeam;

    public void enviarConfirmacaoCadastro(){
        System.out.println(noreply);
        System.out.println("Seu cadastro foi aprovado");
    }

    public void enviarMensagemBoasVidas(){
        techTeam.setEmail("tech@dio.com.br");
        System.out.println(techTeam);
        System.out.println("Bem vindo a tech elite");
    }
}
```

## Properties Value

- Arquivo application.properties: aqui você pode definir variáveis de ambiente, conexão como banco de dados, etc.

```
pring.application.name=first_steps_dio

nome=Jhonny Azevedo
email=jhonny.azevedo@gmail.com
telefones=1145639871,1185239542
```

- @Value: com essa notação você pode pegar valores do application.properties e settar numa variável.

```
public class SistemaMensagem implements CommandLineRunner {

    // você pode settar valores nos atributos com a notação @Value
    // pegando esses valores do application.properties
    @Value("${nome}")
    private String name;
    // você pode definir um valor default
    // caso não ache a variável email, colocando ":valor padrão"
    @Value("${email: email@email.padrao.com}")
    private String email;
    @Value("${telefones}")
    private List<Long> telefone;
}
```

## Configuration Properties

- Atravez da notação @ConfigurationProperties você consegue pegar valores de um obejeto/Bean especificado no application.properties:

- Arquivo application.properties:

```
remetente.nome=Mylena
remetente.email=mystmilli@gmail.com
```

```
@Configuration
// aqui você define como sera o nome do bean/ojeto para pegar os dados do application.properties
// a cada objeto Remetente criado, o Sprind vai settar os dados nos atributos definidos no application.properties
@ConfigurationProperties(prefix = "remetente") // <-----------------
public class Remetente {

    private String nome;
    private String email;
}

// pegando os dados com @Value do application.properties

public class SistemaMensagem implements CommandLineRunner {

    
    @Value("${remetente.nome}")
    private String name;
    @Value("${remetente.email}")
    private String email;
 

```


## Notações Spring

- @Autowired: faz injeção de dependência(faz o new por baixo dos panos).

- @Override: sobreescreve métodos de uma Interface, caso um componente a implemente.

- @Component: quando você define uma classe como @Component você pode injeta-la(comando new), em qualquer parte do container da
  aplicação Spring Boot.

- @Bean: quando você não tem acesso ao código fonte(A Classe não tem a notação @Component), quando necessitar usar uma bliblioteca externa, ou uma Interface sem precisar
  criar uma classe que a implemente:

```
// Aqui passei direto o Bean no main criando um CommandLineRunner 
@Bean
public CommandLineRunner run () {
	return args -> {
		System.out.println("Hello World");
	};
}
```

- Você também pode criar uma classe para armazenar os seus @Beans e usar a anotação @Configuration:

```
@Configuration
public class Beans {

    // Biblioteca externa do Google para lidar com JSONs
    @Bean
    public Gson gson(){
	return new Gson();
    }	
}
```


----------------------> Continuar Conceito de ORM e JPA

























