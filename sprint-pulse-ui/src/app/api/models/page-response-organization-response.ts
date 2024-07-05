/* tslint:disable */
/* eslint-disable */
import { OrganizationResponse } from '../models/organization-response';
export interface PageResponseOrganizationResponse {
  content?: Array<OrganizationResponse>;
  first?: boolean;
  last?: boolean;
  number?: number;
  size?: number;
  totalElements?: number;
  totalPages?: number;
}
