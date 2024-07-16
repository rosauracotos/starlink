import { Component } from '@angular/core';
import {ApiBackendService} from "../../services/ApiBackendService/api.backend.service";
import {SweetAlertService} from "../../services/SweetAlertService/sweet.alert.service";
import {LocalStorageService} from "../../services/LocalStorageService/local.storage.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-ticket-gestion',
  templateUrl: './ticket-gestion.component.html',
  styleUrl: './ticket-gestion.component.css'
})
export class TicketGestionComponent {
  estadosTickets : any[] = [];

  selectedEstadoTicket: any;
  comentario: string = '';
  ticketId: any;
  constructor(private apiBackendService: ApiBackendService,
              private sweetAlertService: SweetAlertService,
              private localStorageService: LocalStorageService,
              private route: ActivatedRoute,
              private router: Router) {}

  ngOnInit() {
    this.ticketId = this.localStorageService.getItem("ticketId");
    this.apiBackendService.obtenerEstadosTicketsLibresPorTicket(this.ticketId).subscribe(
      (response) => {
        this.estadosTickets = response;
      },
      (error) => {
        this.sweetAlertService.showAlertError("Ocurrió un error al conectar al servidor");
      }
    );
  }

  onSubmit() {
    this.apiBackendService.guardarGestionTicket(this.ticketId, this.comentario, this.selectedEstadoTicket).subscribe(
      (response) =>{
        this.sweetAlertService.showAlertSuccess(response.mensaje);
        this.localStorageService.removeItem('ticketId');
        this.router.navigate(['/gestion'])
      },
      (error) => {
        this.sweetAlertService.showAlertError("Ocurrió un error al conectar al servidor");
      }
    );
  }

  cancelar(){
    this.localStorageService.removeItem('ticketId');
    this.router.navigate(['/gestion'])
  }
}
