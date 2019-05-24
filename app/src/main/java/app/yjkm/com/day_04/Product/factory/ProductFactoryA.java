package app.yjkm.com.day_04.Product.factory;

import app.yjkm.com.day_04.Product.ProductA;
import app.yjkm.com.day_04.Product.ProductBase;

/**
 * ProductA 的工厂类
 * 处理生成ProductA的逻辑
 */
public class ProductFactoryA extends ProductFactoryBase {
    @Override
    public ProductBase createProduct() {
        return new ProductA();
    }
}
