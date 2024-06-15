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

## Conceito de ORM e JPA

- JPA(Java Persistence API): é uma especificação baseada em interfaces, que através de um framework realiza operações de persistência
  de objetos em Java.

- ORM(Object Relational Mapping): é um recurso para aproximar o paradigma da orientação a objetos ao contexto de banco de dados
  relacional.

## Spring Data JPA

- Adiciona uma camada sobre o JPA, usa todos os recursos definidos pela especificação JPA, especialmente os mapeamentos de entidade e
  os recursosde persistência baseado em interfaces e anotações. Tem uma implementação sem código do padrão de repositório e a criação
  de consultas de banco de dadis a partir de nomes de métodos.

- Crie um projeto no spring initializr: https://start.spring.io/ , adicione as seguintes dependências: Spring Data JPA,
  Postgres Database. 

## Spring Web

- API(Interface Application Program): é um código que faz a ponte de comunicação entre duas aplicações distintas.

- REST E RESTful: a API REST(Representational State Transfer), é como um guia de boas práticas e RESTful é a capacidade de determinado
sistema aplicar os princípios Rest.

- Princípios arquitetura RESTful:
  - Cliente-servidor: portabilidade entre várias plataformas de interface do usuário e do sevidor.
  - Interface Uniforme: intereção uniforme entre cliente e servidor, hypermedia(HATEOAS).
  - Stateless
  - Cache
  - Camadas

- HATEOAS(Hypermedia as the Engine of Application State): fornece aos clientes links que indicarão como poderá ser feita a navegação
entre seus recursos. Quem for consumir a API deverá saber a rota principal, as respostas das requisições terão todas as demais rotas
possíveis.

- Para criar um projeto Spring Web basta adicionar a dependência ao pom do seu projeto:

```
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
```

### Criando um Controller

```
@RestController
@RequestMapping("/welcome")
public class WelcomeController {

    @GetMapping
    public String welcome() {
        return "Welcome to the Spring Web API";
    }
}
```

## Criando um Repositório

```
@Repository
public interface UserRepository extends JpaRepository<User, UUID> { <-------- <Objeto que será salvo, tipo de ID>

}
```

## Documentando sua API como Swagger

- Insira a dependência do Swagger no seu pom:

```
<!-- Documentação Swagger -->
		<dependency>
			<groupId>org.springdoc</groupId>
			<artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
			<version>2.2.0</version>
		</dependency>
```

- Insira algumas informações no seu arquivo main:

```
@SpringBootApplication
// Congigurações do Swagger, documentação
@OpenAPIDefinition(
		info = @Info(
				title = "REST API",
				description = "API para gerenciamento de usuários",
				version = "1.0",
				termsOfService = "Termo de uso: Open source"
		)
)
public class RestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);
	}

}

```

- Rode sua API e acesse a documentação através do endereço: http://localhost:8080/swagger-ui/index.html


## Exception Handlers

- É o código que estipula o que um progrma fará quando um evendo anômalo interromper o fluxo normal das instruções desse programa.

- Crie um GlobalExceptionHandler:

```
import jakarta.annotation.Resource;
import org.springframework.cglib.proxy.UndeclaredThrowableException;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @Resource
    private MessageSource messageSource;
    private HttpHeaders headers(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
    private ResponseError responseError(String message,HttpStatus statusCode){
        ResponseError responseError = new ResponseError();
        responseError.setStatus("error");
        responseError.setError(message);
        responseError.setStatusCode(statusCode.value());
        return responseError;
    }
    @ExceptionHandler(Exception.class)
    private ResponseEntity<Object> handleGeneral(Exception e, WebRequest request) {
        if (e.getClass().isAssignableFrom(UndeclaredThrowableException.class)) {
            UndeclaredThrowableException exception = (UndeclaredThrowableException) e;
            return handleBusinessException((BusinessException) exception.getUndeclaredThrowable(), request);
        } else {
            String message = messageSource.getMessage("error.server", new Object[]{e.getMessage()}, null);
            ResponseError error = responseError(message,HttpStatus.INTERNAL_SERVER_ERROR);
            return handleExceptionInternal(e, error, headers(), HttpStatus.INTERNAL_SERVER_ERROR, request);
        }
    }
    @ExceptionHandler({BusinessException.class})
    private ResponseEntity<Object> handleBusinessException(BusinessException e, WebRequest request) {
        ResponseError error = responseError(e.getMessage(),HttpStatus.CONFLICT);
        return handleExceptionInternal(e, error, headers(), HttpStatus.CONFLICT, request);
    }
}
```

- Crie Business Exception e ResponseError:

```
public class BusinessException extends RuntimeException {
    public BusinessException(String mensagem) {
        super(mensagem);
    }
    public BusinessException(String mensagem, Object ... params) {
        super(String.format(mensagem, params));
    }
}

-----------------------------

public class ResponseError {
    private Date timestamp = new Date();
    private String status = "error";
    private int statusCode = 400;
    private String error;

    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }

    public Date getTimestamp() {
        return timestamp;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
```

- Ai quando quiser um exceção personalizada lance um BusinessException:

```
@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public void addUsers(User user) {
        User existingUser = repository.findByLogin(user.getLogin());
        if (existingUser != null) {
            throw new BusinessException("Usuário já cadastrado!"); <-------------------
        }
        repository.save(user);
    }
}
```



### Notações Spring Web

- @RequestMapping("/prefixo"): aqui você define uma URI comum a todos os recurso do controller.

- @GetMapping: requisição HTTP do tipo GET.

- @PostMapping: requisição HTTP do tipo Post.

- @PutMapping: requisição HTTP do tipo Put.

- @DeleteMapping: requisição HTTP do tipo DELETE.

- @RequestBody: converte um JSON para o tipo de objeto esperado como parâmetro no método.

- @PathVariable: destermina qual parta da URI será composta por um parâmetro recebido na requisição.




















































