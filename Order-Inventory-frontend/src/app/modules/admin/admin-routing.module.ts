import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { CustomerComponent } from './customer/customer.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { InventoryComponent } from './inventory/inventory.component';
import { OrderComponent } from './order/order.component';
import { ProductComponent } from './product/product.component';

const routes: Routes = [{
  path:'', component:AdminDashboardComponent,children:[
    {path:'dashboard', component:DashboardComponent},
    {path:'customer',component:CustomerComponent},
    {path:'product',component:ProductComponent},
    {path:'inventory',component:InventoryComponent},
    {path:'order',component:OrderComponent},
    {path:'', redirectTo: 'dashboard', pathMatch:'full'},
    
  ], 
},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
