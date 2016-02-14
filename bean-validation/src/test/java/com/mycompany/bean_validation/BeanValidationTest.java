/**
 * 
 */
package com.mycompany.bean_validation;

import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Test;

/**
 * @author colin
 *
 */
public class BeanValidationTest {

	@Test
	public void testValidation_FailValidation() {
		
		Baby baby = new Baby();
		
		// use Bean Validation's default validator
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		
		Set<ConstraintViolation<Baby>> violations = validator.validate(baby);
		
		for(ConstraintViolation<Baby> violation : violations) {
			System.out.println("testValidation_FailValidation:"
					+ violation.getExecutableReturnValue() 
					+ "-" + violation.getInvalidValue() 
					+ "-" + violation.getMessage());
			
		}
		
	}
	
	@Test
	public void testValidation_SucceedValidation() {
		
		Baby baby = new Baby();
		baby.setGender(Gender.MALE);
		baby.setFirstname("Colin");
		baby.setLastname("But");
		baby.setNewBorn(true);
		
		// use Bean Validation's default validator
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		
		Set<ConstraintViolation<Baby>> violations = validator.validate(baby);
		
		if(!violations.isEmpty()) {
			for(ConstraintViolation<Baby> violation : violations) {
				System.out.println("testValidation_SucceedValidation:" 
						+ violation.getExecutableReturnValue() 
						+ "-" + violation.getInvalidValue() 
						+ "-" + violation.getMessage());
				
			}
		}
		else {
			assertEquals(0, violations.size());
			System.out.println("testValidation_SucceedValidation - No violations!");
		}
		
	}
}
