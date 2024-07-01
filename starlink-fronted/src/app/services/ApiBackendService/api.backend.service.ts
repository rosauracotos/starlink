import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {LocalStorageService} from "../LocalStorageService/local.storage.service";
import {Observable} from "rxjs";
import {environment} from "../../../environments/enviroment";
import {Utilidades} from "../../../utils/utilidades";

@Injectable({
  providedIn: 'root'
})
export class ApiBackendService {
  constructor(private http: HttpClient,
              private localStorageService: LocalStorageService) { }

  obtenerTiposDocumentos(): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.get<any>(environment.apiUrl +`api/tipoDocumento/listar`, { headers: headers });
  }

  obtenerEstadosTickets(): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.get<any>(environment.apiUrl +`api/ticketEstado/listar`, { headers: headers });
  }

  obtenerTiposTickets(): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.get<any>(environment.apiUrl +`api/ticketTipo/listar`, { headers: headers });
  }

  obtenerDepartamentos(): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.get<any>(environment.apiUrl +`api/ubigeoDepartamento/listar`, { headers: headers });
  }

  obtenerProvinciasPorDepartamento(departamentoId: number): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.get<any>(environment.apiUrl +`api/ubigeoProvincia/departamento/`+ departamentoId, { headers: headers });
  }

  obtenerDistrirosPorProvincia(provinciaId: number): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.get<any>(environment.apiUrl +`api/ubigeoDistrito/provincia/`+ provinciaId, { headers: headers });
  }

  busquedaPaginadaTickets(selectedTipoDocumento: string, nroDocumento:string, fechaInicio: string, fechaFin:string ,
                          selectedEstadoTicket: any, nroTicket:any, max: number): Observable<any> {
    const body = {
      tipoDocumentoId: Utilidades.esNullOUndefinedoVacio(selectedTipoDocumento) ? null : selectedTipoDocumento,
      numeroDocumento: Utilidades.esNullOUndefinedoVacio(nroDocumento) ? null : nroDocumento,
      fechaInicio: Utilidades.esNullOUndefinedoVacio(fechaInicio) ? null : fechaInicio,
      fechaFin: Utilidades.esNullOUndefinedoVacio(fechaFin) ? null : fechaFin,
      estadoTicketId: Utilidades.esNullOUndefinedoVacio(selectedEstadoTicket) ? null : selectedEstadoTicket,
      nroTicket: Utilidades.esNullOUndefinedoVacio(nroTicket) ? null : nroTicket,
      max: max,
      limite: 0,
    };
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.post<any>(environment.apiUrl +`api/ticket/busquedaPagina`, body, { headers: headers });
  }

  buscarPersonaPorDocumento(nroDocumento: string, tipoDocumento: number): Observable<any> {
    const params = new HttpParams()
      .set('nroDocumento', nroDocumento)
      .set('tipodocumento', tipoDocumento);
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.get<any>(environment.apiUrl +`api/persona/buscarNroDocumento`, { params: params, headers: headers });
  }

  guardarTicket(personaId: number, direccion: string, ticketTipoSeleccionado: number, descripcion: string): Observable<any> {
    const body = {
      persona: {
        id: personaId,
        direccion: direccion
      },
      ticketTipo: {
        id: ticketTipoSeleccionado
      },
      asunto: descripcion
    };
    console.log(body);
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.post<any>(environment.apiUrl +`api/ticket/guardar`, body, { headers: headers });
  }

  editarTicket(tickectId:number, personaId: number, direccion: string, ticketTipoSeleccionado: number, descripcion: string): Observable<any> {
    const body = {
      persona: {
        id: personaId,
        direccion: direccion
      },
      ticketTipo: {
        id: ticketTipoSeleccionado
      },
      asunto: descripcion
    };
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.put<any>(environment.apiUrl +`api/ticket/editar/` + tickectId, body, { headers: headers });
  }

  guardarGestionTicket(ticketId: number, comentario: string, estadoTicketSeleccionado: number): Observable<any> {
    const body = {
      ticket: {
        id: ticketId
      },
      ticketEstado: {
        id: estadoTicketSeleccionado
      },
      comentario: comentario
    };
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.post<any>(environment.apiUrl +`api/ticketGestion/guardarGestion`, body, { headers: headers });
  }

  obtenerTicketPorId(ticketId: number):Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.get<any>(environment.apiUrl +`api/ticket/buscar/`+ ticketId, { headers: headers });
  }

  /*obtenerAreas(): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.get<any>(environment.apiUrl +`api/area/all`, { headers: headers });
  }

  obtenerCargos(): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.get<any>(environment.apiUrl +`api/cargo/all`, { headers: headers });
  }

  obtenerSedes(): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.get<any>(environment.apiUrl +`api/sede/all`, { headers: headers });
  }

  obtenerTiposDocumentos(): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.get<any>(environment.apiUrl +`api/tipoDocumento/all`, { headers: headers });
  }

  obtenerCondicionLaboral(): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.get<any>(environment.apiUrl +`api/grupoLaboral/all`, { headers: headers });
  }

  obtenerArea(): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.get<any>(environment.apiUrl +`api/areaDenominacion/all`, { headers: headers });
  }

  obtenerBanco(): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.get<any>(environment.apiUrl +`api/bancos/all`, { headers: headers });
  }

  obtenerRegimenPensionario(): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.get<any>(environment.apiUrl +`api/regimenPensionario/all`, { headers: headers });
  }

  obtenerComision(): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.get<any>(environment.apiUrl +`api/comisionafp/listar`, { headers: headers });
  }

  obtenerEstadosEmpleados(): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.get<any>(environment.apiUrl +`api/estadoEmpleado/all`, { headers: headers });
  }

  obtenerGruposLaborales(): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.get<any>(environment.apiUrl +`api/grupoLaboral/all`, { headers: headers });
  }

  obtenerGeneros(): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.get<any>(environment.apiUrl +`api/tipoGenero/all`, { headers: headers });
  }

  obtenerEstadoCiviles(): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.get<any>(environment.apiUrl +`api/estadoCivil/all`, { headers: headers });
  }

  obtenerTurnos(): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.get<any>(environment.apiUrl +`api/turno/all`, { headers: headers });
  }

  obtenerDepartamentos(): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.get<any>(environment.apiUrl +`api/ubigeoDepartamento/all`, { headers: headers });
  }

  obtenerProvinciasPorDepartamento(departamentoId: number): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.get<any>(environment.apiUrl +`api/ubigeoProvincia/departamento/`+ departamentoId, { headers: headers });
  }

  obtenerDistrirosPorProvincia(provinciaId: number): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.get<any>(environment.apiUrl +`api/ubigeoDistrito/provincia/`+ provinciaId, { headers: headers });
  }

  obtenerColaboradorPorId(colaboradorId: number):Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.get<any>(environment.apiUrl +`api/colaborador/`+ colaboradorId, { headers: headers });
  }

  obtenerColaboradorLaboralesPorId(colaboradorId: number):Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.get<any>(environment.apiUrl +`api/colaboradorLaboral/obtenerPorColaborador/`+ colaboradorId, { headers: headers });
  }

  guardarColaborador(apellidoPaterno: string, apellidoMaterno: string, nombre: string, numeroIdentificacion: string,
                     fechaNacimiento: string, celular: string, direccion: string, correo: string, tipoDocumentoId: number,
                     tipoGeneroId: number, estadoCiviloId: number, distritoId: number): Observable<any> {

    const body = {
      apellidoPaterno: apellidoPaterno,
      apellidoMaterno: apellidoMaterno,
      nombre: nombre,
      numeroIdentificacion: numeroIdentificacion,
      fechaNacimiento: fechaNacimiento,
      celular: celular,
      direccion: direccion,
      correo: correo,
      tipoDocumento: {
        id :tipoDocumentoId
      },
      tipoGenero: {
        id :tipoGeneroId
      },
      estadoCivil: {
        id :estadoCiviloId
      },
      distrito: {
        id :distritoId
      }
    };
    console.log(body);
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.post<any>(environment.apiUrl +`api/colaborador/guardar`, body, { headers: headers });
  }

  editarColaborador(apellidoPaterno: string, apellidoMaterno: string, nombre: string, numeroIdentificacion: string,
                     fechaNacimiento: string, celular: string, direccion: string, correo: string, tipoDocumentoId: number,
                     tipoGeneroId: number, estadoCiviloId: number, distritoId: number, colaboradorId: number): Observable<any> {

    const body = {
      apellidoPaterno: apellidoPaterno,
      apellidoMaterno: apellidoMaterno,
      nombre: nombre,
      numeroIdentificacion: numeroIdentificacion,
      fechaNacimiento: fechaNacimiento,
      celular: celular,
      direccion: direccion,
      correo: correo,
      tipoDocumento: {
        id :tipoDocumentoId
      },
      tipoGenero: {
        id :tipoGeneroId
      },
      estadoCivil: {
        id :estadoCiviloId
      },
      distrito: {
        id :distritoId
      }
    };
    console.log(body);
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.put<any>(environment.apiUrl +`api/colaborador/editar/` + colaboradorId, body, { headers: headers });
  }

  cesarColaborador(colaboradorId: number): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.put<any>(environment.apiUrl +`api/colaborador/cesar/` + colaboradorId, null, { headers: headers });
  }

  anularColaborador(colaboradorId: number): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.put<any>(environment.apiUrl +`api/colaborador/anular/` + colaboradorId, null, { headers: headers });
  }

  guardarColaboradorLaboral(numCupss: string, numeroCuenta: string,
                            colaboradorId: number, comisionafpId: number,
                            sedeId: number, grupoLaboralId: number, areaDenominacionId: number,
                            regimenPensionarioId: number, cargoId:number, bancoId: number): Observable<any> {

    const body = {
      numCupss: numCupss,
      numeroCuenta: numeroCuenta,
      colaborador: {
        id :colaboradorId
      },
      sede: {
        id :sedeId
      },
      cargo: {
        id :cargoId
      },
      grupoLaboral: {
        id :grupoLaboralId
      },
      areaDenominacion: {
        id :areaDenominacionId
      },
      banco: {
        id :bancoId
      },
      regimenPensionario: {
        id :regimenPensionarioId
      },
      comisionafp: {
        id: comisionafpId
      }
    };
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.post<any>(environment.apiUrl +`api/colaboradorLaboral/guardar`, body, { headers: headers });
  }

  editarColaboradorLaboral( colaboradorLaboralId: number, numCupss: string, numeroCuenta: string, comisionafpId: number,
                            sedeId: number, grupoLaboralId: number, areaDenominacionId: number,
                            regimenPensionarioId: number, cargoId:number, bancoId: number): Observable<any> {

    const body = {
      numCupss: numCupss,
      numeroCuenta: numeroCuenta,
      sede: {
        id :sedeId
      },
      cargo: {
        id :cargoId
      },
      grupoLaboral: {
        id :grupoLaboralId
      },
      areaDenominacion: {
        id :areaDenominacionId
      },
      banco: {
        id :bancoId
      },
      regimenPensionario: {
        id :regimenPensionarioId
      },
      comisionafp: {
        id: comisionafpId
      }
    };
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.put<any>(environment.apiUrl +`api/colaboradorLaboral/editar/` + colaboradorLaboralId, body, { headers: headers });
  }

  busquedaPaginadaPersonal(numeroDocumento: string, nombre:string, apellidoPaterno: string, apellidoMaterno:string ,
                           selectedArea: any, selectedCargo:any, selectedTipoDocumento: any, selectedEstadoEmpleado: any,
                           selectedGrupoLaboral: any, max: number): Observable<any> {
    const body = {
      numeroDocumento: Utilidades.esNullOUndefinedoVacio(numeroDocumento) ? null : numeroDocumento,
      nombre: Utilidades.esNullOUndefinedoVacio(nombre) ? null : nombre,
      apellidoPaterno: Utilidades.esNullOUndefinedoVacio(apellidoPaterno) ? null : apellidoPaterno,
      apellidoMaterno: Utilidades.esNullOUndefinedoVacio(apellidoMaterno) ? null : apellidoMaterno,
      areaId: Utilidades.esNullOUndefinedoVacio(selectedArea) ? null : selectedArea,
      cargoId: Utilidades.esNullOUndefinedoVacio(selectedCargo) ? null : selectedCargo,
      tipoDocumentoId: Utilidades.esNullOUndefinedoVacio(selectedTipoDocumento) ? null : selectedTipoDocumento,
      estadoEmpleadoId: Utilidades.esNullOUndefinedoVacio(selectedEstadoEmpleado) ? null : selectedEstadoEmpleado,
      grupoLaboralId: Utilidades.esNullOUndefinedoVacio(selectedGrupoLaboral) ? null : selectedGrupoLaboral,
      max: max,
      limite: 0,
    };
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.post<any>(environment.apiUrl +`api/colaborador/busquedaPagina`, body, { headers: headers });
  }

  guardarTurnos(bodyTurnos: any): Observable<any> {

    const body = bodyTurnos;
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.post<any>(environment.apiUrl +`api/colaboradorHorario/guardarTurnos`, body, { headers: headers });
  }

  obtenerListaPDFs(numeroIdentificacion: string, anio: number): Observable<any> {
    const params = new HttpParams()
      .set('dni', numeroIdentificacion)
      .set('year', anio);
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.get<any>(environment.apiUrl +`api/boletasPago/pdfs-info`, { params: params, headers: headers });
  }

  visualizarPDF(nombreArchivo: string): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.get<any>(environment.apiUrl +`api/boletasPago/pdf/` + nombreArchivo, {headers: headers, responseType: 'blob' as 'json' });
  }*/

}
