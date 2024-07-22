import { Component } from '@angular/core';
import {ApiBackendService} from "../../services/ApiBackendService/api.backend.service";
import {LocalStorageService} from "../../services/LocalStorageService/local.storage.service";
import {SweetAlertService} from "../../services/SweetAlertService/sweet.alert.service";

@Component({
  selector: 'app-ticket-reporte',
  templateUrl: './ticket-reporte.component.html',
  styleUrl: './ticket-reporte.component.css'
})
export class TicketReporteComponent {
  ticketId: any;
  pdfBase64: string = '';

  constructor(private apiBackendService: ApiBackendService,
              private sweetAlertService: SweetAlertService,
              private localStorageService: LocalStorageService) {}

  ngOnInit() {
    this.ticketId = this.localStorageService.getItem("ticketId");
    this.apiBackendService.visualizarReportePDF(this.ticketId).subscribe(
      (blob: Blob) => {
        const reader = new FileReader();
        reader.readAsDataURL(blob);
        reader.onloadend = () => {
          this.pdfBase64 = (reader.result as string).split(',')[1];
        };
      },
      (error) => {
        this.sweetAlertService.showAlertError("Ocurrió un error al conectar al servidor");
      }
    );

  }
}
