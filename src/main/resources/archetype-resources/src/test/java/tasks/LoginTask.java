package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddCandidateTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                // Ingresar a la sección de "Recruitment"
                Click.on("//span[text()='Recruitment']"),

                // Hacer clic en el botón de "Add"
                Click.on("//button[contains(.,'+ Add')]"),

                // Llenar el formulario de candidato
                Enter.theValue("Ximena").into("//input[@name='firstName']"),
                Enter.theValue("Espinosa").into("//input[@name='lastName']"),
                Enter.theValue("xime@pruebas.com").into("//input[@name='email']"),
                Enter.theValue("3182603555").into("//input[@name='contactNo']"),

                // Seleccionar la vacante del menú desplegable
                SelectFromOptions.byVisibleText("QA").from("//select[@name='vacancy']"),

                // Hacer clic en el botón de "Save"
                Click.on("//button[text()='Save']")
        );
    }

    // Método estático para invocar la tarea
    public static AddCandidateTask withXimenaEspinosa() {
        return instrumented(AddCandidateTask.class);
    }
}


