import { OnInit } from '@angular/core';
import { Component } from '@angular/core';
import { Inventory } from '../classes/inventory';
import { InventoryService } from '../services/inventory/inventory.service';
import { ShipmentStatusSoldProducts } from '../classes/ShipmentStatusSoldProducts';
import { InventoryProductStoreShipmentStatusSum } from '../classes/InventoryProductStoreShipmentStatusSum';
import { InventoryStoreProductOrderStatus } from '../classes/InventoryStoreProductOrderStatus';
import { InventoryShipment } from '../classes/InventoryShipment';
import { ProductCustomerStore } from '../classes/ProductCustomerStore';

@Component({
  selector: 'app-inventory',
  templateUrl: './inventory.component.html',
  styleUrls: ['./inventory.component.css']
})
export class InventoryComponent implements OnInit {
  inventoryProductStoreShipmentStatusSum !: InventoryProductStoreShipmentStatusSum[];
  inventoryStoreProductOrderStatus!: InventoryStoreProductOrderStatus[];

  shipmentStatusSoldProducts: ShipmentStatusSoldProducts = new ShipmentStatusSoldProducts();
  inventoryShipment!: InventoryShipment[];
  constructor(private service: InventoryService) { }
  inventorys!: Inventory[];

  filterForStoreId: boolean = false;
  bind: boolean = true;
  inventoryId!: number
  inventory: Inventory = new Inventory();
  orderId!: number
  storeId!: number
  shipmentId!: number;
  filterForOrderId: boolean = false;
  filterFordetailsOrderId: boolean = false;
  filterOrderId: boolean = false;
  filterbystoreId: boolean = false;
  filterbyshipment: boolean = false;
  filterbyshipmentstatus: boolean = false;
  shipment: boolean = false;
  soldProducts: boolean = false;
  shipmentStatus!: string;
  productCustomerStore: ProductCustomerStore = new ProductCustomerStore();
  ngOnInit(): void {
    this.getAllInventory();
  }
  onSubmit() {

  }
  getAllInventory() {
    this.service.getAllInventory().subscribe(data => {
      this.inventorys = data
    })

  }
  goBackToAdd() {
    this.inventory = new Inventory();
    this.filterForOrderId = false;
    this.filterFordetailsOrderId = false;
    this.filterOrderId = false;
    this.filterbystoreId = false;
    this.filterbyshipment = false;
    this.filterbyshipmentstatus = false;
    this.shipment = false;
    this.soldProducts = false;
  }
  getProductCustomerStoreByOrderId() {
    this.service.getProductCustomerStoreByOrderId(this.storeId).subscribe(data => {
      this.productCustomerStore = data;

    })
  }
  getInventoryDetailsByOrderId() {

    this.service.getInventoryDetailsByOrderId(this.orderId).subscribe(data => {
      this.inventoryProductStoreShipmentStatusSum = data;
    })
  }
  getProductOrderStatusByStoreId() {
    this.service.getProductOrderStatusByStoreId(this.storeId).subscribe(data => {
      this.inventoryStoreProductOrderStatus = data;
    })
  }
  setUpGetUsersByOrderId() {
    this.filterForOrderId = true;
    this.bind = !this.bind
  }
  setUpGetByOrderId() {
    this.filterOrderId = true;
    this.bind = !this.bind
  }
  setUpGetOrderstatusbystoreId() {
    this.filterbystoreId = true;
    this.bind = !this.bind
  }
  setUpInventoryByshipmentId() {
    this.filterbyshipment = true;
    this.bind = !this.bind

  }
  getInventoryShipmentById() {
    this.service.getInventoryShipmentById(this.shipmentId).subscribe(data => {
      this.inventoryShipment = data;
    })
  }
  getCountOfSoldProductsByShipmentStatus() {
    this.filterbyshipmentstatus = true;
    this.bind = !this.bind
    this.service.getCountOfSoldProductsByShipmentStatus().subscribe(data => {
      this.shipmentStatusSoldProducts = data;
    })
  }
}
