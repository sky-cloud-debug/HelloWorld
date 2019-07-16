package com.water.util;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * 
 * 类名: l<BR>
 * 描述: <BR>
 * 创建人:毕燕东 <BR>
 * 时间：2016年5月27日-下午9:41:10 <BR>
 * 
 * @version 1.0
 */
public class WaterUtil {
	public static double irriauto(double waterholdingCapacity, double soilHumi,
			double Hi, double Ai) {
		System.out.println(waterholdingCapacity+","+soilHumi+","+Hi+","+Ai);
		double i = 6.67 * (waterholdingCapacity*0.01 - soilHumi*0.01) * Hi * Ai;
		return i;
	}

	public static double getP(double P0) {
		double f = 0;
		if (P0 < 50) {
			f = 1.0;
		} else if (P0 < 150) {
			f = 0.75;
		} else {
			f = 0.7;
		}
		return P0 * f;
	}

	public static double j(int year, int month, int date) {
		int b;
		if (year % 4 == 0) {
			if (month > 2) {
				b = 1;
			} else {
				b = 0;
			}
		} else {
			b = 0;
		}
		int a;
		if (month < 3) {
			a = 2;
		} else {
			a = 0;
		}
		double J;
		J = Math.floor(275 * month / 9 - 30) - 2 + a + date + b;
		return J;
	}

	public static double getas(int month) {
		double as;
		double a = 0;
		if (month == 12 || month <= 2) {
			a = 0.152;
		} else {
			if (month <= 5) {
				a = 0.115;
			} else if (month <= 8) {
				a = 0.301;
			} else if (month <= 11) {
				a = 0.172;
			}
		}

		as = a;
		return as;
	}

	public static double getbs(int month) {
		double a = 0;
		double bs;
		if (month == 12 || month <= 2) {
			a = 0.556;
		} else {
			if (month <= 5) {
				a = 0.588;
			} else if (month <= 8) {
				a = 0.311;
			} else if (month <= 11) {
				a = 0.536;
			}
		}

		bs = a;
		return bs;
	}

	public static double geti(double beginsoilHumi, double endsoilHumi,
			double beginDepth, double endDepth, double Kc, double ET0, double P) {
		double ETa = Kc * ET0;
		double W2 = 10 * endsoilHumi * endDepth;
		double W1 = 10 * beginsoilHumi * beginDepth;
		double Wr = 10 * (endDepth - beginDepth) * endsoilHumi;
		double I = W2 - W1 - Wr - P - ETa;
		return I;
	}

	public static double getW1(double beginsoilHumi, double beginDepth) {
		double W1 = 10 * beginsoilHumi * beginDepth;
		return W1;
	}
	public static double getW2(double endsoilHumi, double endDepth) {
		double W1 = 10 * endsoilHumi *endDepth;
		return W1;
	}

	public static double getWr(double endDepth, double beginDepth,
			double endsoilHumi) {
		double Wr = 10 * (endDepth - beginDepth) * endsoilHumi;
		return Wr;
	}

	public static double getET0(double altitude, double u10, double latitude,
			double hightemp, double lowtemp, double airhumi, double sunlong,
			int year, int month, int date) {
		double gamma = 0.00163 / 2.45 * 101.3 * Math.pow(
				(293 - 0.0065 * altitude) / 293, 5.26);
		double u2 = u10 * 4.87 / Math.log(67.8 * 10 - 5.42);
		double δ = 0.409 * Math.sin(2 * Math.PI / 365 * j(year, month, date)
				- 1.39);
		double φ = latitude * Math.PI / 180;
		double omegas = Math.acos(-Math.tan(φ) * Math.tan(δ));
		double dr = 1 + 0.033 * Math.cos(2 * Math.PI / 365
				* j(year, month, date));
		double Ra = 118.08
				/ Math.PI
				* dr
				* (omegas * Math.sin(φ) * Math.sin(δ) + Math.cos(φ)
						* Math.cos(δ) * Math.sin(omegas));
		double eTmax = 0.6108 * Math.exp(17.27 * hightemp / (hightemp + 237.3));
		double eTmin = 0.6108 * Math.exp(17.27 * lowtemp / (lowtemp + 237.3));
		double es = (eTmax + eTmin) / 2;
		double ea = es * airhumi / 100;
		double san = 4098
				* 0.6108
				* Math.exp((17.27 * (hightemp + lowtemp) / 2)
						/ ((hightemp + lowtemp) / 2 + 237.3))
				/ Math.pow((hightemp + lowtemp) / 2 + 237.3, 2);
		double Rns = 0.77
				* (getas(month) + getbs(month) * (sunlong)
						/ (24 * omegas / Math.PI)) * Ra;
		double Rnl = 2.4515
				* Math.pow(10, -9)
				* (1.35
						* (getas(month) + getbs(month) * (sunlong / 1)
								/ (24 * omegas / Math.PI))
						/ (0.75 + 0.00002 * altitude) - 0.35)
				* (0.34 - 0.14 * Math.sqrt(ea))
				* (Math.pow((hightemp + 273.16), 4) + Math.pow(
						(lowtemp + 273.16), 4));
		double Rn = Rns - Rnl;
		double ET0 = (0.408 * san * (Rn) + gamma * 900 * u2 * (es - ea)
				/ ((hightemp + lowtemp) / 2 + 273))
				/ (san + gamma * (1 + 0.34 * u2));
		return ET0;
	}

	public static void main(String[] args) {
		// System.out.println(getET0(73.2,2.8,35.32,0.2,-8.1,73,1.6));
		sendIrrigationCode(1, 10);
	}

	public static void sendIrrigationCode(Integer outletNumber, int waterNum) {
		try {
			Socket socket = new Socket("202.194.131.174",8028 );
			OutputStream os = socket.getOutputStream();
			os.write(new String(("BB0118554325143#F"+outletNumber+"B1"+waterNum+"$").getBytes("UTF-8"),"gbk").getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}