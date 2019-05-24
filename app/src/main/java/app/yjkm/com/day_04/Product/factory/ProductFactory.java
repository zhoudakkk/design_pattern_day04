package app.yjkm.com.day_04.Product.factory;


import app.yjkm.com.day_04.Product.ProductBase;

/**
 * 反射来实现工厂模式
 */
public class ProductFactory extends ProductFactoryBaseClz {

    @Override
    public <T extends ProductBase> T createProduct(Class<T> clz) {
        ProductBase p = null;
        try {
            p = (ProductBase) Class.forName(clz.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) p;
    }
}
