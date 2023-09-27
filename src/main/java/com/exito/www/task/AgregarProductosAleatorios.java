package com.exito.www.task;

import com.exito.www.interactions.AgregarCantidadRandom;
import com.exito.www.interactions.SeleccionProductoRandom;
import com.exito.www.userInterface.PaginaPrincipalUI;
import com.exito.www.userInterface.ProductosUI;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.ArrayList;
import java.util.List;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class AgregarProductosAleatorios implements Task {

    public static List<WebElementFacade> listaBtnProductos=new ArrayList<>();
    PaginaPrincipalUI paginaPrincipalUI=new PaginaPrincipalUI();
    ProductosUI productosUI=new ProductosUI();


    @Override
    public <T extends Actor> void performAs(T actor) {
        
        if (paginaPrincipalUI.POPUP_PROMOCION.resolveFor(actor).isClickable()) {
            actor.attemptsTo(
                    Click.on(paginaPrincipalUI.POPUP_PROMOCION)
            );
        }
        actor.attemptsTo(
                WaitUntil.the(paginaPrincipalUI.BTN_MEMU, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(paginaPrincipalUI.BTN_MEMU),
                WaitUntil.the(paginaPrincipalUI.BTN_CATEGORIA, isClickable()).forNoMoreThan(5).seconds(),
                Click.on(paginaPrincipalUI.BTN_CATEGORIA),
                WaitUntil.the(paginaPrincipalUI.BTN_SUBCATEGORIA, isClickable()).forNoMoreThan(5).seconds(),
                Click.on(paginaPrincipalUI.BTN_SUBCATEGORIA),
                WaitUntil.the(productosUI.LBL_RESULTADOS, isVisible()).forNoMoreThan(30).seconds()
        );
        listaBtnProductos= productosUI.BTN_PRODUCTOS.resolveAllFor(actor);
        for (int i = 0; i < 5; i++) {
            actor.attemptsTo(
                    SeleccionProductoRandom.seleccionar(),
                    WaitUntil.the(productosUI.BTN_AGREGAR, isClickable()).forNoMoreThan(10).seconds(),
                    Click.on(productosUI.BTN_AGREGAR),
                    AgregarCantidadRandom.agregar()
            );
            actor.remember("nombreProducto"+(i+1), (productosUI.LBL_NOMBRE_PRODUCTO).resolveFor(actor).getText());
            actor.remember("precioProducto"+(i+1), (productosUI.LBL_PRECIO_PRODUCTO).resolveFor(actor).getText());
            actor.remember("cantidadProducto"+(i+1),  (productosUI.LBL_CANTIDAD_PRODUCTOS).resolveFor(actor).getText());
            actor.attemptsTo(
                    WaitUntil.the(productosUI.BTN_CONTINUAR_COMPRANDO, isClickable()).forNoMoreThan(10).seconds(),
                    Click.on(productosUI.BTN_CONTINUAR_COMPRANDO),
                    WaitUntil.the(productosUI.BTN_PRODUCTOS, isClickable()).forNoMoreThan(5).seconds()
            );

            if (productosUI.POPUP_PRODUCTO_AGREGADO.resolveFor(actor).isClickable()) {
                actor.attemptsTo(
                        WaitUntil.the(productosUI.POPUP_PRODUCTO_AGREGADO, isNotCurrentlyVisible()).forNoMoreThan(5).seconds()
                );
            }
        }
        actor.attemptsTo(
                WaitUntil.the(productosUI.BTN_CARRITO, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(productosUI.BTN_CARRITO)
        );

    }

    public static Performable alCarrito() {
        return Instrumented.instanceOf(AgregarProductosAleatorios.class).withProperties();
    }
}

