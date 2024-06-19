import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginComponent} from "./components/login/login.component";
import {InicioComponent} from "./components/inicio/inicio.component";

const routes: Routes = [
/*
  { path: 'personal', component: PersonalComponent },
  { path: 'personal-formulario', component: PersonalFormularioComponent },
  { path: 'personal-laborales-formulario', component: PersonalDatosLaboralesComponent },
  { path: 'boletas', component: BoletasComponent },
  { path: 'turnos', component: TurnosComponent },*/
  { path: '', component: LoginComponent },
  { path: 'inicio', component: InicioComponent },
  { path: '', redirectTo: '/inicio', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
