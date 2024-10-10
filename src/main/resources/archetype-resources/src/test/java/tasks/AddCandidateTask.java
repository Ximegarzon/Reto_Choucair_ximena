public class LoginTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"),
                Enter.theValue("Admin").into("//input[@name='username']"),
                Enter.theValue("admin123").into("//input[@name='password']"),
                Click.on(".orangehrm-login-button")
        );
    }
}
