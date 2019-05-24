package app.yjkm.com.day_04.Product.factory;

import app.yjkm.com.day_04.Product.ProductB;
import app.yjkm.com.day_04.Product.ProductBase;

/**
 * Product 的基础工厂类
 * 处理生成的公共逻辑
 */
public abstract class ProductFactoryBase {

    public abstract ProductBase createProduct();


}
