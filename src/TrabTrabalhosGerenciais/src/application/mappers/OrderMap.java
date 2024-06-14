package application.mappers;

import application.viewModels.OrderItemVM;
import application.viewModels.OrderVM;
import domain.model.entities.*;
import domain.model.enums.PersonTypeEnum;
import domain.model.enums.ProductTypeEnum;
import domain.model.valueObjects.Address;

import java.util.ArrayList;
import java.util.List;

public class OrderMap {
    public static OrderModel getOrderModel(OrderVM orderVM){
        List<OrderItemModel> orderItemsModel = new ArrayList<>();
        for(OrderItemVM itemVM : orderVM.products){
            ProductModel productModel = new ProductModel(
                    itemVM.product.id,
                    itemVM.product.name,
                    ProductTypeEnum.fromInteger(itemVM.product.type),
                    new UnitModel(itemVM.product.unitName, itemVM.product.unitSymbol),
                    itemVM.product.costPrice,
                    itemVM.product.salePrice,
                    itemVM.product.stock
            );
            orderItemsModel.add(new OrderItemModel(productModel, itemVM.quantity,itemVM.salePrice));
        }

        PersonModel customerModel = new PersonModel(
                orderVM.customer.id,
                orderVM.customer.name,
                orderVM.customer.document,
                PersonTypeEnum.fromInteger(orderVM.customer.type),
                new Address(orderVM.customer.street, orderVM.customer.number, orderVM.customer.neighborhood, orderVM.customer.city, orderVM.customer.state, orderVM.customer.postalCode, orderVM.customer.country),
                orderVM.customer.birthDate,
                orderVM.customer.observation,
                orderVM.customer.customer,
                orderVM.customer.staff,
                orderVM.customer.supplier
        );

        PersonModel staffModel = new PersonModel(
                orderVM.waiter.id,
                orderVM.waiter.name,
                orderVM.waiter.document,
                PersonTypeEnum.fromInteger(orderVM.waiter.type),
                new Address(orderVM.waiter.street, orderVM.waiter.number, orderVM.waiter.neighborhood, orderVM.waiter.city, orderVM.waiter.state, orderVM.waiter.postalCode, orderVM.waiter.country),
                orderVM.waiter.birthDate,
                orderVM.waiter.observation,
                orderVM.waiter.customer,
                orderVM.waiter.staff,
                orderVM.waiter.supplier
        );

        return new OrderModel(customerModel,staffModel,orderItemsModel,orderVM.invoiced,orderVM.discount, orderVM.observation);
    }
}
