import { HotelBookingAngularPage } from './app.po';

describe('hotel-booking-angular App', () => {
  let page: HotelBookingAngularPage;

  beforeEach(() => {
    page = new HotelBookingAngularPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
