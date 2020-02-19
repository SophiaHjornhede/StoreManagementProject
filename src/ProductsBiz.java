import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class ProductsBiz implements Serializable {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductsBiz)) return false;
        ProductsBiz that = (ProductsBiz) o;
        return Objects.equals(wareHouseList, that.wareHouseList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wareHouseList);
    }

    private List<Products> wareHouseList= new ArrayList<>(10);
    public List<Products> getWareHouseList() {
        return wareHouseList;
    }


    public static void addProducts(ProductsBiz biz) {

        System.out.println("We have several types of products in our store, they are:");
        System.out.println("jackets");
        System.out.println("shoes");
        System.out.println("gloves");
        System.out.println("pants");
        System.out.println("");

        Products tmp = new Products();

            try {
                Scanner s = new Scanner(System.in);

                System.out.println("What is the product's type you want to add in this time?");
                String type = s.nextLine();
                tmp.setType(type);

                System.out.println("What is the product's brand?");
                String brand = s.nextLine();
                tmp.setBrand(brand);

                System.out.println("What is the product's color?");
                String color = s.nextLine();
                tmp.setColor(color);

                System.out.println("What is the product's size?");
                int size = s.nextInt();
                tmp.setSize(size);

                System.out.println("What is the product's price?");
                int price = s.nextInt();
                tmp.setPrice(price);

                System.out.println("What is the product's eon-code?");
                int eonCode = s.nextInt();
                tmp.setEonCode(eonCode);

                System.out.println("How many products in this type?");
                int count = s.nextInt();
                tmp.setCount(count);
                } catch (Exception e) {
                System.out.println("Error creating product!");
                e.printStackTrace();
            }

            System.out.println("");
            System.out.println("Now the new products are added up successfully, all the products in the warehouse are listed as below:");
            System.out.println("");

            biz.add(tmp);
            productsInWarehouse(biz);
    }



    public static void sellProducts(ProductsBiz biz) {

        System.out.println("");
        System.out.println("Below list all the available products in the warehouse, chose one of them to sell.");
        System.out.println("");

        productsInWarehouse(biz);

        System.out.println("");
        System.out.println("Please choose the product-to-sell by typing in the product code.");
        System.out.println("The product code is:  ");
        Scanner s = new Scanner(System.in);
        try {
           int tmp= s.nextInt();
           removeProduct(biz,tmp);

    } catch (Exception e)
        {
            System.out.println("Error selecting");
        }
    }


    public static void removeProduct(ProductsBiz biz, int ean){

        System.out.println("");
        System.out.println("The chosen product is successfully removed from the warehouse." );
        System.out.println("The current products in the warehouse are listed below: " );
        System.out.println("");


        for(int i=0; i<biz.getWareHouseList().size();i++)
        {
            if( biz.getWareHouseList().get(i).getEonCode()==ean&&biz.getWareHouseList().get(i).getCount()==0 ) {
                System.out.println("No products left");
                break;
            }
            if( biz.getWareHouseList().get(i).getEonCode()==ean){
                int prod=biz.getWareHouseList().get(i).getCount();
                biz.getWareHouseList().get(i).setCount(prod-1);
            }
        }

        productsInWarehouse(biz);

    }

    public static void searchType(ProductsBiz biz){

        System.out.println("We have several types of products in our store, they are:");
        System.out.println("jackets");
        System.out.println("shoes");
        System.out.println("gloves");
        System.out.println("pants");

        System.out.println("Please write down the products type you want to search in the store:");


        List<Products> type = new ArrayList<>(biz.getWareHouseList());

        Scanner s = new Scanner(System.in);
        String sTemp= s.nextLine();
        List<Products> result = type.stream()
                .filter(x -> sTemp.equals(x.getType()))
                .collect(Collectors.toList());

        result.forEach(System.out::println);
    }


    void add(Products p){
        wareHouseList.add(p);
    }

    private void discount() {

    }

    public static void productsInWarehouse(ProductsBiz biz) {

        System.out.println("********************** Star-Light Baby Store: Warehouse info ********************** ");
        System.out.println("");
        biz.getWareHouseList().stream().forEach(e -> System.out.println("Type: " + e.getType() +
                ", Brand: " + e.getBrand() + ", Size; " + e.getSize() + " , Color: " + e.getColor() +
                ", Product code; " + e.getEonCode() + ", Price: " + e.getPrice() + ", Amount: " + e.getCount()));
    }

    }



