package com.session3.springboot.deptempmgmt.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.session3.springboot.deptempmgmt.bean.AddressBean;
import com.session3.springboot.deptempmgmt.entity.Address;

import com.session3.springboot.deptempmgmt.service.AddressService;


@RestController
public class AddressController {
	@Autowired
	private AddressService addressService;
	
	@GetMapping("/getAddresses")
	public ResponseEntity<List<AddressBean>> findAllAddresses(){
		List<AddressBean> addresses = addressService.findAllAddress();
		return ResponseEntity.ok(addresses);
	}
	
	@GetMapping("addresses/{addid}")
	public ResponseEntity<Address> findAddresstById(@PathVariable("addid") int addid)
	{
		Address addressRetrieved=addressService.findAddressById(addid);
		return ResponseEntity.ok(addressRetrieved);
	}
	@PostMapping("/plusAddress")
	public ResponseEntity<String> addAddress(@RequestBody Address addr)
	{
		addressService.addAddress(addr);
		return ResponseEntity.ok("Address Saved");
	}
	@PutMapping("/updateAddress")
	public ResponseEntity<String> updateAddress(@RequestBody Address addr)
	{
		addressService.addAddress(addr);
		return ResponseEntity.ok("Address Updated");
	}
	@DeleteMapping("/delete/{addid}")
	public ResponseEntity<Void> deleteAddress(@PathVariable("addid") int addid)
	{
		addressService.deleteAddressById(addid);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	
	

}
