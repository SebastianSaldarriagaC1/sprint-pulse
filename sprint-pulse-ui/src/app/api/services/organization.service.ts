/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { BaseService } from '../base-service';
import { ApiConfiguration } from '../api-configuration';
import { StrictHttpResponse } from '../strict-http-response';

import { createOrganization } from '../fn/organization/create-organization';
import { CreateOrganization$Params } from '../fn/organization/create-organization';
import { findAllBooks } from '../fn/organization/find-all-books';
import { FindAllBooks$Params } from '../fn/organization/find-all-books';
import { findOrganizationById } from '../fn/organization/find-organization-by-id';
import { FindOrganizationById$Params } from '../fn/organization/find-organization-by-id';
import { OrganizationResponse } from '../models/organization-response';
import { PageResponseOrganizationResponse } from '../models/page-response-organization-response';


/**
 * Organization API
 */
@Injectable({ providedIn: 'root' })
export class OrganizationService extends BaseService {
  constructor(config: ApiConfiguration, http: HttpClient) {
    super(config, http);
  }

  /** Path part for operation `findAllBooks()` */
  static readonly FindAllBooksPath = '/organization';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findAllBooks()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAllBooks$Response(params?: FindAllBooks$Params, context?: HttpContext): Observable<StrictHttpResponse<PageResponseOrganizationResponse>> {
    return findAllBooks(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findAllBooks$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAllBooks(params?: FindAllBooks$Params, context?: HttpContext): Observable<PageResponseOrganizationResponse> {
    return this.findAllBooks$Response(params, context).pipe(
      map((r: StrictHttpResponse<PageResponseOrganizationResponse>): PageResponseOrganizationResponse => r.body)
    );
  }

  /** Path part for operation `createOrganization()` */
  static readonly CreateOrganizationPath = '/organization';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `createOrganization()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  createOrganization$Response(params: CreateOrganization$Params, context?: HttpContext): Observable<StrictHttpResponse<number>> {
    return createOrganization(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `createOrganization$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  createOrganization(params: CreateOrganization$Params, context?: HttpContext): Observable<number> {
    return this.createOrganization$Response(params, context).pipe(
      map((r: StrictHttpResponse<number>): number => r.body)
    );
  }

  /** Path part for operation `findOrganizationById()` */
  static readonly FindOrganizationByIdPath = '/organization/{organization-id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findOrganizationById()` instead.
   *
   * This method doesn't expect any request body.
   */
  findOrganizationById$Response(params: FindOrganizationById$Params, context?: HttpContext): Observable<StrictHttpResponse<OrganizationResponse>> {
    return findOrganizationById(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findOrganizationById$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findOrganizationById(params: FindOrganizationById$Params, context?: HttpContext): Observable<OrganizationResponse> {
    return this.findOrganizationById$Response(params, context).pipe(
      map((r: StrictHttpResponse<OrganizationResponse>): OrganizationResponse => r.body)
    );
  }

}
