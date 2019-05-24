package app.yjkm.com.day_04.Product.factory;

import app.yjkm.com.day_04.Product.ProductBase;

public abstract class ProductFactoryBaseClz {
    public abstract <T extends ProductBase> T createProduct(Class<T> clz);
}
