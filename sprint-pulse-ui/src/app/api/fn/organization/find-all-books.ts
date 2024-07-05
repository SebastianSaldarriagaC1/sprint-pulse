/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { PageResponseOrganizationResponse } from '../../models/page-response-organization-response';

export interface FindAllBooks$Params {
  page?: number;
}

export function findAllBooks(http: HttpClient, rootUrl: string, params?: FindAllBooks$Params, context?: HttpContext): Observable<StrictHttpResponse<PageResponseOrganizationResponse>> {
  const rb = new RequestBuilder(rootUrl, findAllBooks.PATH, 'get');
  if (params) {
    rb.query('page', params.page, {});
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<PageResponseOrganizationResponse>;
    })
  );
}

findAllBooks.PATH = '/organization';
