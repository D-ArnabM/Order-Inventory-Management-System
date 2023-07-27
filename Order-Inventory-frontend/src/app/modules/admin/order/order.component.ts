import { Component, OnInit } from '@angular/core';
import { OrderService } from '../services/order/order.service';
import { OrderStatusCount } from '../classes/OrderStatusCount';
import { OrderStoreList } from '../classes/OrderStoreList';
import { Order } from '../classes/order';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {

  constructor(private orderService: OrderService) { }
  ngOnInit(): void {
    this.getAllOrders();
  }


  Orders!: Order[];
  Order: Order = new Order();
  orderstatusCount: OrderStatusCount = new OrderStatusCount();


  order!: OrderStatusCount[];


  storeId!:number;
  orderStatus!:string;



  isFormValid():boolean{
    return(
       !!this.Order.orderId&&
       !!this.Order.orderTimestamp&&
       !!this.Order.customer.customerId&&
       !!this.Order.orderStatus&&
       !!this.Order.store.storeId
       
       );
    
   }


  orderStoreList!: OrderStoreList[];
  updateBind: boolean = false;
  filterForStatus: boolean = false;
  filterForStore: boolean = false;





  goBackToAdd() {
    this.updateBind = false;
    this.filterForStatus = false;
    this.filterForStore = false;
    this.Order = new Order();
  }

  getOrderToUpdate(ord: Order) {


    this.updateBind = true;
    this.Order.orderId = ord.orderId;
    this.Order.orderTimestamp = ord.orderTimestamp;
    this.Order.customer.customerId = ord.customer.customerId;
    this.Order.orderStatus = ord.orderStatus;
    this.Order.store.storeId = ord.store.storeId;

  }



  getAllOrders() {
    this.orderService.getAllOrders().subscribe(data => {
      this.Orders = data;
    })
  }

  addOrder() {
    this.orderService.addOrder(this.Order).subscribe(data => {
      console.log(data);
      alert("Record Created Successfully");
    })
  }

  updateOrder() {
    this.orderService.updateOrder(this.Order).subscribe(data => {
      console.log(data);
      alert("Record Updated Successfully");
    })
  }

  deleteOrder(Order: Order) {
    this.orderService.deleteOrder(Order).subscribe(() => {
      this.orderService.getAllOrders().subscribe(Orders => {
        this.Orders = Orders;
        alert('Record deleted Successfully');
    })

  })
}

  getFilterForStatus() {
    this.filterForStatus = true;
  }

  getOrderCountByStatus() {

    this.orderService.getOrderCountByStatus(this.orderStatus).subscribe(data => {
      this.order = data;
    })
  }

  getFilterForStore() {
    this.filterForStore = true;
  }

  setOrderListByStoreId() {
    this.filterForStore = true;
  }

  getOrderListByStoreId() {
    this.orderService.getOrderListByStoreId(this.storeId).subscribe(data => {
      this.orderStoreList = data;
    }
    )
  }
}

