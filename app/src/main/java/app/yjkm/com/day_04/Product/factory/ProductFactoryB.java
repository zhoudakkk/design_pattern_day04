package app.yjkm.com.day_04.Product.factory;

import app.yjkm.com.day_04.Product.ProductB;
import app.yjkm.com.day_04.Product.ProductBase;

/**
 * ProductB 的工厂类
 * 处理生成ProductB的逻辑
 */
public class ProductFactoryB extends ProductFactoryBase {
    @Override
    public ProductBase createProduct() {
        return new ProductB();
    }
}
