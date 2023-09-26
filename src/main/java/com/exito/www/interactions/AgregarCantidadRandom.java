package com.exito.www.interactions;

import com.exito.www.userInterface.ProductosUI;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.Random;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class AgregarCantidadRandom implements Interaction {


    Random random = new Random();


    ProductosUI productosUI=new ProductosUI();
    @Override
    public <T extends Actor> void performAs(T actor) {
        int cantidadRandom = random.nextInt(10) + 1;
        for (int i = 1; i < cantidadRandom; i++) {
            actor.attemptsTo(
                    WaitUntil.the(productosUI.BTN_AGREGAR_MAS, isClickable()).forNoMoreThan(10).seconds(),
                    Click.on(productosUI.BTN_AGREGAR_MAS)
            );
        }
    }
    public static Performable agregar (){
        return Instrumented.instanceOf(AgregarCantidadRandom.class).withProperties();
    }
}
