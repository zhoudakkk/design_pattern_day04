package app.yjkm.com.day_04;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import app.yjkm.com.day_04.Product.ProductA;
import app.yjkm.com.day_04.Product.ProductBase;
import app.yjkm.com.day_04.Product.factory.ProductFactory;
import app.yjkm.com.day_04.Product.factory.ProductFactoryA;
import app.yjkm.com.day_04.otherType.ClockActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ProductFactory factory = new ProductFactory();
        ProductA product = factory.createProduct(ProductA.class);
        product.method();
        ArrayList list = new ArrayList();
        list.iterator();

        Intent intent = new Intent(MainActivity.this, ClockActivity.class);
        startActivity(intent);
    }

    /**
     *  工厂模式 其实就是抽象封装 公共逻辑公共化
     */
    private void getProductA() {
        ProductFactoryA factoryA = new ProductFactoryA();
        ProductBase product = factoryA.createProduct();
    }
}
