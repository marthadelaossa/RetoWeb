package com.exito.www.stepDefinitions;

import com.exito.www.task.AgregarProductosAleatorios;
import com.exito.www.task.ValidarProductosCarrito;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class CarritoDeComprasAleatorioStepDefinitions {

    @Before
    public void configuration() {
        OnStage.setTheStage(new OnlineCast());
     }

    @Dado("que el usuario ingresa a la pagina del exito (.*)$")
    public void queElUsuarioIngresaALaPaginaDelExito  (String url) {
        WebDriverManager.chromedriver().setup();
        OnStage.theActorCalled("Usuario").wasAbleTo(Open.url(url));
    }
    @Cuando("el usuario agrega cinco productos al carrito aleatoriamente")
    public void elUsuarioAgregaCincoProductoAlCarritoAleatoriamente() {
        OnStage.theActorInTheSpotlight().attemptsTo(AgregarProductosAleatorios.alCarrito());
    }
    @Entonces("el usuario podra ver sus productos agregadaos en el carrito")
    public void elUsuarioPodraVerSusProductosAgregadaosEnElCarrito() {
        OnStage.theActorInTheSpotlight().attemptsTo(ValidarProductosCarrito.validar());
    }
}
