import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
/*  { path: '', component: LoginComponent },
  { path: 'inicio', component: InicioComponent },
  { path: 'personal', component: PersonalComponent },
  { path: 'personal-formulario', component: PersonalFormularioComponent },
  { path: 'personal-laborales-formulario', component: PersonalDatosLaboralesComponent },
  { path: 'boletas', component: BoletasComponent },
  { path: 'turnos', component: TurnosComponent },*/
  { path: '', redirectTo: '/inicio', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
