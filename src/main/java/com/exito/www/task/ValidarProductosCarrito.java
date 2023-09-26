package com.exito.www.task;

import com.exito.www.userInterface.CarritoUI;
import com.exito.www.utils.ObtenerValor;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static net.serenitybdd.core.Serenity.getDriver;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidarProductosCarrito implements Task {

    CarritoUI carritoUI=new CarritoUI();

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(carritoUI.INPUT_EMAIL, isEnabled()).forNoMoreThan(10).seconds(),
                Enter.theValue("juanperez@gmail.com").into(carritoUI.INPUT_EMAIL),
                Click.on(carritoUI.BTN_CONFIRMAR),
                WaitUntil.the(carritoUI.LBL_CARRITO, isVisible()).forNoMoreThan(10).seconds()
        );
        List<WebElementFacade> listaProductos=carritoUI.LBL_TOTAL_PRODUCTOS.resolveAllFor(actor);
        int totalProductosCarrito=listaProductos.size();
        Ensure.that(totalProductosCarrito).equals("5");
        for (int i = 1; i < 6; i++) {
            String nombreProducto = actor.recall("nombreProducto"+i);
            String  cantidad = actor.recall("cantidadProducto"+i);
            String  precioTotal =actor.recall("precioProducto"+i);
            actor.attemptsTo(
                    WaitUntil.the(CarritoUI.LBL_NOMBRE_PRODUCTO(nombreProducto), isVisible()).forNoMoreThan(10).seconds()
            );
            cantidad= ObtenerValor.cantidad(cantidad);
            precioTotal=String.valueOf(Integer.parseInt(ObtenerValor.precio(precioTotal))*Integer.parseInt(cantidad));
            Ensure.that(precioTotal).equals(ObtenerValor.cantidad(getDriver().findElement(CarritoUI.LBL_VALOR_PRODUCTOS(nombreProducto)).getText()));
            Ensure.that(cantidad).equals(ObtenerValor.cantidad(getDriver().findElement(CarritoUI.LBL_CANTIDAD_PRODUCTO(nombreProducto)).getText()));
        }

    }

    public static Performable validar() {
        return Instrumented.instanceOf(ValidarProductosCarrito.class).withProperties();
    }
}

