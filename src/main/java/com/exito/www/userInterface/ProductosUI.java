package com.exito.www.userInterface;

import net.serenitybdd.screenplay.targets.Target;

public class ProductosUI {

    public final Target LBL_RESULTADOS = Target.the("Precio producto").locatedBy ("//span[@class='exito-vtex-components-4-x-currencyContainer']");
    public final Target BTN_PRODUCTOS = Target.the("Boton compra rapida producto").locatedBy ("//*[@class='exito-vtex-components-4-x-buyButton productSummaryBuyButtonProductRich']");
    public final Target BTN_AGREGAR = Target.the("Boton agregar al carrito").locatedBy ("//*[@class='exito-vtex-components-4-x-mainBuyButton']");
    public final Target BTN_AGREGAR_MAS = Target.the("Boton agregar mas productos al carrito").locatedBy ("//button[@class='exito-vtex-components-4-x-buttonActions exito-vtex-components-4-x-productSummaryAddToCar  product-summary-add-to-car-plus']");
    public final Target BTN_CONTINUAR_COMPRANDO = Target.the("Continuar Comprando").locatedBy ("//*[@class='exito-vtex-components-4-x-continue']");
    public final Target POPUP_PRODUCTO_AGREGADO = Target.the("PopUp Producto Agregado").locatedBy ("//*[@class='vtex-alert__close-icon pointer flex items-center pa3 white nr3 nv3']");
    public final Target LBL_NOMBRE_PRODUCTO = Target.the("Nombre Producto Agregado").locatedBy ("//*[@class='exito-vtex-components-4-x-defaultModalBody']//child::span[@class='vtex-store-components-3-x-productBrand ']");
    public final Target LBL_PRECIO_PRODUCTO  = Target.the("Precio Producto Agregado").locatedBy ("//*[@class='exito-vtex-components-4-x-defaultModalBody']//child::div[@class='exito-vtex-components-4-x-PricePDP']");
    public final Target LBL_CANTIDAD_PRODUCTOS = Target.the("Cantidad Producto Agregado").locatedBy ("//*[@class='exito-vtex-components-4-x-stepperContainerQty']");

    public final Target BTN_CARRITO = Target.the("Carrito de Compras").locatedBy ("//a[@class='exito-header-3-x-minicartLink']");

}
