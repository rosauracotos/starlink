import {NgModule} from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {FormsModule} from "@angular/forms";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatIconModule} from "@angular/material/icon";
import {MatInputModule} from "@angular/material/input";
import {MatCardModule} from "@angular/material/card";
import {MatButtonModule} from "@angular/material/button";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {SweetAlertService} from "./services/SweetAlertService/sweet.alert.service";
import {MatTableModule} from "@angular/material/table";
import {NgxUiLoaderConfig, NgxUiLoaderHttpModule, NgxUiLoaderModule, SPINNER} from "ngx-ui-loader";
import {LoaderInterceptor} from "./interceptors/loader.interceptor";
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatMenuModule} from "@angular/material/menu";
import {MatTooltipModule} from "@angular/material/tooltip";
import {MatGridListModule} from "@angular/material/grid-list";
import {MatListModule} from "@angular/material/list";
import {MatExpansionModule} from "@angular/material/expansion";
import {MatSelectModule} from '@angular/material/select';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {provideNativeDateAdapter} from '@angular/material/core';
import {MatCheckbox, MatCheckboxModule} from "@angular/material/checkbox";
import {LoginComponent} from "./components/login/login.component";
import {MenuComponent} from "./components/menu/menu.component";
import {AsideComponent} from "./components/aside/aside.component";
import {InicioComponent} from "./components/inicio/inicio.component";
import {TicketsComponent} from "./components/tickets/tickets.component";
import {TicketsFormularioComponent} from "./components/tickets-formulario/tickets-formulario.component";
import {GestionComponent} from "./components/gestion/gestion.component";
import {DashboardComponent} from "./components/dashboard/dashboard.component";
import {TicketGestionComponent} from "./components/ticket-gestion/ticket-gestion.component";
import {TicketDialogComponent} from "./components/ticket-dialog/ticket-dialog.component";
import {MatDialogModule} from "@angular/material/dialog";
import {NgxExtendedPdfViewerModule} from "ngx-extended-pdf-viewer";
import {TicketReporteComponent} from "./components/ticket-reporte/ticket-reporte.component";

const ngxUiLoaderConfig: NgxUiLoaderConfig = {
  "bgsColor": "red",
  "bgsOpacity": 0.5,
  "bgsPosition": "bottom-right",
  "bgsSize": 60,
  "bgsType": "ball-spin-clockwise",
  "blur": 5,
  "delay": 0,
  "fastFadeOut": true,
  "fgsColor": "#35c8ea",
  "fgsPosition": "center-center",
  "fgsSize": 60,
  "fgsType": "ball-spin-clockwise",
  "gap": 24,
  "logoPosition": "center-center",
  "logoSize": 80,
  "masterLoaderId": "master",
  "overlayBorderRadius": "0",
  "overlayColor": "rgba(40, 40, 40, 0.8)",
  "pbColor": "red",
  "pbDirection": "ltr",
  "pbThickness": 3,
  "hasProgressBar": true,
  "text": "",
  "textColor": "#FFFFFF",
  "textPosition": "center-center",
  "maxTime": -1,
  "minTime": 300
};
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    MenuComponent,
    AsideComponent,
    InicioComponent,
    TicketsComponent,
    TicketsFormularioComponent,
    GestionComponent,
    DashboardComponent,
    TicketGestionComponent,
    TicketDialogComponent,
    TicketReporteComponent
  ],
  imports: [
    BrowserModule,
    NgxUiLoaderModule.forRoot(ngxUiLoaderConfig),
    NgxUiLoaderHttpModule.forRoot({showForeground: true}),
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    MatIconModule,
    MatInputModule,
    MatCardModule,
    MatButtonModule,
    MatTableModule,
    MatToolbarModule,
    MatMenuModule,
    MatTooltipModule,
    MatGridListModule,
    MatListModule,
    MatExpansionModule,
    MatSelectModule,
    MatFormFieldModule,
    MatDatepickerModule,
    MatCheckbox,
    MatCheckboxModule,
    MatDialogModule,
    NgxExtendedPdfViewerModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: LoaderInterceptor,
      multi: true
    },
    SweetAlertService,
    provideNativeDateAdapter()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
