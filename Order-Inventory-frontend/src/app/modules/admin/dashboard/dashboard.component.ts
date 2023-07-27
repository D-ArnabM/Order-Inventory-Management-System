import { AfterViewInit, Component, OnInit } from '@angular/core';
import { Insight } from '../classes/insight';
import { CustomerService } from '../services/customer/customer.service';
import { OrderService } from '../services/order/order.service';
import { ProductService } from '../services/product/product.service';
import { Chart } from 'chart.js/auto';
import { ProductCountByDate } from '../classes/productcountbydate';
import { InventoryService } from '../services/inventory/inventory.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit, AfterViewInit {

  customerCount: number = 0;
  inventoryCount: number = 0;
  productCount: number = 0;
  orderCount: number = 0;
  year: number = 2023;
  month: number = 0;
  insights: Insight[] = [];

  productCountByDate: ProductCountByDate[] = [];
  public chart: any;
  public chart2: any;
  months: string[] = [];
  noOfOrders: string[] = [];
  noOfProducts: string[] = [];
  revenue: string[] = [];
  productId: string[] = [];
  productCountPerMonth: string[] = [];

  constructor(
    private customerService: CustomerService,
    private productService: ProductService,
    private orderService: OrderService,
    private inventoryService: InventoryService
  ) { }


  ngOnInit(): void {
    this.getAllCusts();
    this.getProductCount();
    this.getAllInventory();
    this.getAllOrdes();
    this.getInsight();
    this.getProductCountByDate();

  }

  ngAfterViewInit(): void {
    setTimeout(() => {
      this.createChart1();
      this.createChart2();
    });
  }

  getAllOrdes(): void {
    this.orderService.getAllOrders().subscribe(data=>{
      this.orderCount = data.length;
    })
  }
  getAllInventory(): void {
    this.inventoryService.getAllInventory().subscribe(data => {
      this.inventoryCount = data.length;
    })
  }

  getAllCusts(): void {
    this.customerService.getAllCustomers().subscribe(data => {
      this.customerCount = data.length;
    });
  }

  getProductCount(): void {
    this.productService.getAllProducts().subscribe(data => {
      this.productCount = data.length;
    });
  }

  changeMonth(m: any): void {
    this.month = m.target.value;
  }

  changeYear(y: any): void {
    this.year = y.target.value;
  }

  getInsight(): void {
    if (this.month != 0) {
      this.orderService.getAllOrderInsightByYearorMonth(this.year, this.month).subscribe(data => {
        this.insights = data;
        this.updateChartData();
      });
    }
    if (this.month == 0) {
      this.orderService.getAllOrderInsightByYear(this.year).subscribe(data => {
        this.insights = data;
        console.log(this.insights);
        this.updateChartData();
      });
    }
    this.getProductCountByDate();
  }

  getProductCountByDate(): void {
    if (this.month != 0) {
      this.orderService.getAllProductCount(this.year, this.month).subscribe(data => {
        this.productCountByDate = data;
        this.updateChartData2();
      });
    }
    if (this.month == 0) {
      this.orderService.getAllProductCountByYear(this.year).subscribe(data => {
        this.productCountByDate = data;
        this.updateChartData2();
      });
    }
  }
  updateChartData(): void {
    this.months = [];
    this.noOfOrders = [];
    this.noOfProducts = [];
    this.revenue = [];
    this.insights.forEach(insight => {
      this.months.push(`${insight.month}`);
      this.noOfOrders.push(`${insight.noOfOrders}`);
      this.noOfProducts.push(`${insight.quantity}`);
      this.revenue.push(`${insight.totalSales}`);
    });
    if (this.chart) {
      this.chart.destroy();
    }
    this.createChart1();
  }

  updateChartData2(): void {
    this.productId = [];
    this.productCountPerMonth = [];

    this.productCountByDate.forEach(data => {
      this.productId.push(`${data.id}`);
      this.productCountPerMonth.push(`${data.count}`);
    });
    console.log(this.productCountByDate);
    if (this.chart2) {
      this.chart2.destroy();
    }
    this.createChart2();
  }


  createChart1(): void {
    this.chart = new Chart("MyChart", {
      type: 'bar',
      data: {
        labels: this.months,
        datasets: [
          {
            label: "No. Of Orders",
            data: this.noOfOrders,
            backgroundColor: 'blue'
          },
          {
            label: "No. Of Products",
            data: this.noOfProducts,
            backgroundColor: 'limegreen'
          },
          {
            label: "Revenue in Dollars",
            data: this.revenue,
            backgroundColor: '#fc8c03'
          }
        ]
      },
    });
  }

  createChart2(): void {
    this.chart2 = new Chart("MyChart2", {
      type: 'bar',
      data: {
        labels: this.productId,
        datasets: [
          {
            label: "No. Of Orders",
            data: this.productCountPerMonth,
            backgroundColor: '#ffee00'
          }
        ]
      },
    });
  }
}
