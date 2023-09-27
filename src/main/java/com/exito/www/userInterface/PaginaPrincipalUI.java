package com.exito.www.userInterface;

import net.serenitybdd.screenplay.targets.Target;


public class PaginaPrincipalUI {
    public final Target POPUP_PROMOCION = Target.the("PopUp Producto Oferta").locatedBy ("//*[@id='wps-overlay-close-button']");

    public  final Target BTN_MEMU = Target.the("Menu").locatedBy ("//*[@id='category-menu']");
    public  final Target BTN_CATEGORIA = Target.the("Categoría").locatedBy ("//li[@id='undefined-nivel2-Hogar y muebles']");
    public  final Target BTN_SUBCATEGORIA = Target.the("Subcategoría").locatedBy ("//a[@href='/hogar/muebles/escritorios']");

}
