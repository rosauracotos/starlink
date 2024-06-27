import { Component } from '@angular/core';
import {ApiBackendService} from "../../services/ApiBackendService/api.backend.service";
import {SweetAlertService} from "../../services/SweetAlertService/sweet.alert.service";
import {LocalStorageService} from "../../services/LocalStorageService/local.storage.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Utilidades} from "../../../utils/utilidades";

@Component({
  selector: 'app-tickets-formulario',
  templateUrl: './tickets-formulario.component.html',
  styleUrl: './tickets-formulario.component.css'
})
export class TicketsFormularioComponent {
  ocultarBotonGuardar: boolean = false;
  isReadOnly: boolean = false;
  ticketId: any;

  tiposDocumentos: any[] = [];
  tiposTickets: any[] = [];
  departamentos: any[] = [];
  provincias: any[] = [];
  distritos: any[] = [];

  numeroDocumento: any;
  celular: any;
  nombrecompleto: any;
  email: any;
  direccion:any;
  descripcion: any;
  personaId: any;
  selectedTipoDocumento:any;
  selectedTipoTicket:any;
  selectedDepartamento:any;
  selectedProvincia:any;
  selectedDistrito:any;

  private timeout: any;

  constructor(private apiBackendService: ApiBackendService,
              private sweetAlertService: SweetAlertService,
              private localStorageService: LocalStorageService,
              private route: ActivatedRoute,
              private router: Router) {}

  ngOnInit() {
    this.apiBackendService.obtenerTiposDocumentos().subscribe(
      (response) => {
        this.tiposDocumentos = response;
      },
      (error) => {
        this.sweetAlertService.showAlertError("Ocurrió un error al conectar al servidor");
      }
    );
    this.apiBackendService.obtenerTiposTickets().subscribe(
      (response) => {
        this.tiposTickets = response;
      },
      (error) => {
        this.sweetAlertService.showAlertError("Ocurrió un error al conectar al servidor");
      }
    );
    this.apiBackendService.obtenerDepartamentos().subscribe(
      (response) => {
        this.departamentos = response;
      },
      (error) => {
        this.sweetAlertService.showAlertError("Ocurrió un error al conectar al servidor");
      }
    );
    this.ticketId = this.localStorageService.getItem("ticketId");
    this.ocultarBotonGuardar = this.localStorageService.getItem("ocultarBotonGuardar");
    if (!Utilidades.esNullOUndefinedoVacio(this.ticketId)) {
      //this.obtenerDatosColaborador(this.colaboradorId);
    }
    this.route.queryParams.subscribe(params => {
      this.isReadOnly = params['readOnly'] === 'true';
    });
  }

  onDepartamentoSelectionChange(event: any) {
    this.selectedProvincia = null;
    this.selectedDistrito = null;
    this.apiBackendService.obtenerProvinciasPorDepartamento(this.selectedDepartamento).subscribe(
      (response) => {
        this.provincias = response;
      },
      (error) => {
        this.sweetAlertService.showAlertError("Ocurrió un error al conectar al servidor");
      }
    );
  }

  onProvinciaSelectionChange(event:any) {
    this.selectedDistrito = null;
    this.apiBackendService.obtenerDistrirosPorProvincia(this.selectedProvincia).subscribe(
      (response) => {
        this.distritos = response;
      },
      (error) => {
        this.sweetAlertService.showAlertError("Ocurrió un error al conectar al servidor");
      }
    );
  }

  cancelar() {
    this.router.navigate(['/tickets'])
  }

  onNroDocumentoChange() {
    clearTimeout(this.timeout);
    this.timeout = setTimeout(() => {
      this.consultarPersonaPorDocumento();
    }, 2000);
  }

  consultarPersonaPorDocumento() {
    this.apiBackendService.buscarPersonaPorDocumento(this.numeroDocumento, this.selectedTipoDocumento).subscribe(
      (response) => {
        this.celular = response.telefono;
        this.nombrecompleto = response.apellidoPaterno + " " + response.apellidoMaterno + " " + response.nombre;
        this.email = response.correo;
        this.direccion = response.direccion;
        this.personaId = response.id;
        this.selectedDistrito = response.distrito.id;
        this.selectedDepartamento = response.distrito.provincia.departamento.id;
        this.selectedProvincia = response.distrito.provincia.id;

        this.apiBackendService.obtenerProvinciasPorDepartamento(this.selectedDepartamento).subscribe(
          (response) => {
            this.provincias = response;
          },
          (error) => {
            this.sweetAlertService.showAlertError("Ocurrió un error al conectar al servidor");
          }
        );

        this.apiBackendService.obtenerDistrirosPorProvincia(this.selectedProvincia).subscribe(
          (response) => {
            this.distritos = response;
          },
          (error) => {
            this.sweetAlertService.showAlertError("Ocurrió un error al conectar al servidor");
          }
        );


      },
      (error) => {
        this.sweetAlertService.showAlertError("Ocurrió un error al conectar al servidor");
      }
    );
  }

  onSubmit() {
    this.apiBackendService.guardarTicket(this.personaId, this.direccion, this.selectedTipoTicket, this.descripcion).subscribe(
      (response) =>{
        this.sweetAlertService.showAlertSuccess(response.mensaje);
        this.router.navigate(['/tickets'])
      },
      (error) => {
        this.sweetAlertService.showAlertError("Ocurrió un error al conectar al servidor");
      }
    );
  }

}
