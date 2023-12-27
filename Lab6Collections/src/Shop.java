import java.util.*;

public class Shop {
    public static void main(String[] args) {
        LinkedHashMap<Product, Integer> productsList = new LinkedHashMap<>();
        Product product1 = new Product("Мыло", 5);
        Product product2 = new Product("Подушка", 50);
        Product product3 = new Product("Ножницы", 20);
        sell(productsList, product1);
        sell(productsList, product1);
        sell(productsList, product3);
        sell(productsList, product3);
        sell(productsList, product3);
        sell(productsList, product2);
        printProductsList(productsList);
        System.out.println(getTotalAmount(productsList));
        printMostPopularProduct(productsList);
    }

    private static void sell(LinkedHashMap<Product, Integer> productsList, Product product){
        if (productsList.get(product) == null) {
            productsList.put(product, 1);
        }
        else{
            productsList.put(product, productsList.get(product) + 1);
        }
    }
    private static void printProductsList(LinkedHashMap<Product, Integer> productsList){
        for(var key : productsList.keySet()){
            System.out.println(key.getName());
        }
    }
    private static int getTotalAmount(LinkedHashMap<Product, Integer> productsList){
        int amount = 0;
        for(var key : productsList.keySet()){
            amount += key.getCost() * productsList.get(key);
        }
        return amount;
    }
    private static void printMostPopularProduct(LinkedHashMap<Product, Integer> productList){
        ArrayList<Map.Entry<Product, Integer>> list = new ArrayList<>(productList.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Product, Integer>>(){
            @Override
            public int compare(Map.Entry<Product, Integer> o1, Map.Entry<Product, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        System.out.println("Самый популярный товар: " + list.get(0).getKey().getName() + " был продан " + list.get(0).getValue() + " раз");
    }
}
