package com.dao;

import com.entity.Country;

public class CountryDaoClient {

	public static void main(String[] args) {

		try {

			CountryDaoImpl countryDaoImpl = new CountryDaoImpl();

			Country country = new Country();

			country.setCountryName("United State");
			country.setCountry_code("USA");

			countryDaoImpl.saveCountry(country);

			System.out.println("Saved Successfully.............");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
