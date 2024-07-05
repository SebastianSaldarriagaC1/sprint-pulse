/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { OrganizationResponse } from '../../models/organization-response';

export interface FindOrganizationById$Params {
  'organization-id': number;
}

export function findOrganizationById(http: HttpClient, rootUrl: string, params: FindOrganizationById$Params, context?: HttpContext): Observable<StrictHttpResponse<OrganizationResponse>> {
  const rb = new RequestBuilder(rootUrl, findOrganizationById.PATH, 'get');
  if (params) {
    rb.path('organization-id', params['organization-id'], {});
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<OrganizationResponse>;
    })
  );
}

findOrganizationById.PATH = '/organization/{organization-id}';
