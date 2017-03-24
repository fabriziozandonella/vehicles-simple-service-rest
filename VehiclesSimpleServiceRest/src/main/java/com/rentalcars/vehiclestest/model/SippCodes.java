/**
 * 
 */
package com.rentalcars.vehiclestest.model;

/**
 * @author Fabrizio Zandonella
 * 
 */
public final class SippCodes {

	public static final String CARTYPE_M = "Mini";
	public static final String CARTYPE_E = "Economy";
	public static final String CARTYPE_C = "Compact";
	public static final String CARTYPE_I = "Intermediate";
	public static final String CARTYPE_S = "Standard";
	public static final String CARTYPE_F = "Full size";
	public static final String CARTYPE_P = "Premium";
	public static final String CARTYPE_L = "Luxury";
	public static final String CARTYPE_X = "Special";

	public static final String DOORS_B = "2 doors";
	public static final String DOORS_C = "4 doors";
	public static final String DOORS_D = "5 doors";
	public static final String DOORS_W = "Estate";
	public static final String DOORS_T = "Convertible";
	public static final String DOORS_F = "SUV";
	public static final String DOORS_P = "Pick up";
	public static final String DOORS_V = "Passenger Van";

	public static final String TRANSMISSION_A = "Automatic";
	public static final String TRANSMISSION_M = "Manual";

	public static final String FUEL_AC_N = "Petrol/no AC";
	public static final String FUEL_AC_R = "Petrol/AC";

	public static final String NOT_FOUND = "Not Found";

	public enum CarType{M,E,C,I,S,F,P,L,X;

		public String carType(){
			try{
				switch (this) {
				case M:
					return CARTYPE_M;
				case E:
					return CARTYPE_E;
				case C:
					return CARTYPE_C;
				case I:
					return CARTYPE_I;
				case S:
					return CARTYPE_S;
				case F:
					return CARTYPE_F;	
				case P:
					return CARTYPE_P;	
				case L:
					return CARTYPE_L;	
				case X:
					return CARTYPE_X;	
				default:
					throw new AssertionError("Unknown CarType " + this);
				}
			}catch(Exception e){
				return NOT_FOUND;	
			}
		}
	}

	public enum DoorsCarType{B,C,D,W,T,F,P,V;

		public String doorsCarType(){

			switch (this) {
			case B:
				return DOORS_B;
			case C:
				return DOORS_C;
			case D:
				return DOORS_D;
			case W:
				return DOORS_W;
			case T:
				return DOORS_T;
			case F:
				return DOORS_F;
			case P:
				return DOORS_P;
			case V:
				return DOORS_V;				
			default:	
				throw new AssertionError("Unknown DoorsCarType " + this);
			}

		}
	}

	public enum Transmission{M,A;

		public String transmission(){
			switch (this) {
			case M:
				return TRANSMISSION_M;
			case A:
				return TRANSMISSION_A;
			default:
				throw new AssertionError("Unknown Transmission " + this);
			}
		}

		public int score(){
			switch (this) {
			case M:
				return 1;
			case A:
				return 5;
			default:
				throw new AssertionError("Unknown score Transmission  " + this);
			}
		}
	}
	public enum FuelAC{N,R;

		public String fuelAC(){
			switch (this) {
			case R:
				return FUEL_AC_R;
			case N:
				return FUEL_AC_N;
			default:
				throw new AssertionError("Unknown FuelAC " + this);
			}
		}

		public int score(){
			switch (this) {
			case R:
				return 2;
			case N:
				return 0;				
			default:
				throw new AssertionError("Unknown score FuelAC " + this);
			}
		}
	}
}