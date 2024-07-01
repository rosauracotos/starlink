import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginComponent} from "./components/login/login.component";
import {InicioComponent} from "./components/inicio/inicio.component";
import {TicketsComponent} from "./components/tickets/tickets.component";
import {TicketsFormularioComponent} from "./components/tickets-formulario/tickets-formulario.component";
import {GestionComponent} from "./components/gestion/gestion.component";
import {DashboardComponent} from "./components/dashboard/dashboard.component";
import {TicketGestionComponent} from "./components/ticket-gestion/ticket-gestion.component";

const routes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'tickets', component: TicketsComponent },
  { path: 'ticket-formulario', component: TicketsFormularioComponent },
  { path: 'gestion', component: GestionComponent },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'inicio', component: InicioComponent },
  { path: 'ticket-gestion', component: TicketGestionComponent },
  { path: '', redirectTo: '/inicio', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
