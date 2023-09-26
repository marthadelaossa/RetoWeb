package com.exito.www.interactions;


import com.exito.www.task.AgregarProductosAleatorios;
import com.exito.www.userInterface.ProductosUI;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.Random;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;


public class SeleccionProductoRandom implements Interaction {

    ProductosUI productosUI=new ProductosUI();
    Random random = new Random();

    @Override
    public <T extends Actor> void performAs(T actor) {
        int productoRandom = random.nextInt(AgregarProductosAleatorios.listaBtnProductos.size());
        actor.attemptsTo(
               WaitUntil.the(productosUI.BTN_PRODUCTOS, isClickable()).forNoMoreThan(5).seconds(),
               Scroll.to(productosUI.LBL_RESULTADOS)
        );
        AgregarProductosAleatorios.listaBtnProductos.get(productoRandom).click();
        AgregarProductosAleatorios.listaBtnProductos.remove(productoRandom);
    }
        public static Performable seleccionar (){
                return Instrumented.instanceOf(SeleccionProductoRandom.class).withProperties();
    }
}
