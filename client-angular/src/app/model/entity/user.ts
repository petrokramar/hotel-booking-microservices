import {Role} from './role';

export class User {
  username: string;
  password: string;
  enabled: boolean;
  firstName: string;
  lastName: string;
  roles: Role[]
}
