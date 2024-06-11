package br.com.jhonnyazevedo.first_steps_dio;

public class Remetente {

    private String email;

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Remetente{" +
                "email='" + email + '\'' +
                '}';
    }
}
