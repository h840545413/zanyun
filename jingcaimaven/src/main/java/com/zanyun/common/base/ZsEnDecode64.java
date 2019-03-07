package com.zanyun.common.base;




public class ZsEnDecode64 {
//private static final String cBase64 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz=!";
  private static final String cBase64 = "01234589ABCFKLMNOPQRSTUVWXYZcdefjklmnopqrwxyz=!67DEabstuv@#$%^&*GHIJghi";
	/**
	 * 加密
	 * @param strSour
	 * @return
	 */
	public static String encode64(String strSour) {
		strSour = chinaToUnicode(strSour);
		byte a, b, c;
		byte s1, s2, s3, s4;
		int i;
		byte[] ret = null;

		switch (strSour.length() % 3) {
		case 1:
			strSour = strSour + "  ";
			break;

		case 2:
			strSour = strSour + " ";
			break;

		default:
			break;
		}

		byte ah = 0;
		byte al = 0;

		for (i = 0; i < strSour.length() / 3; i++) {
			a = strSour.getBytes()[3 * i];
			b = strSour.getBytes()[3 * i + 1];
			c = strSour.getBytes()[3 * i + 2];
			
			s1 = (byte) (a >> 2);

			ah = a;
			al = b;
			ah = (byte) (ah & 0x03);
			ah = (byte) (ah << 4);
			al = (byte) (al >> 4);
			ah = (byte) (ah | al);
			s2 = ah;

			ah = b;
			al = c;
			ah = (byte) (ah & 0x0f);
			ah = (byte) (ah << 2);
			al = (byte) (al >> 6);
			ah = (byte) (ah | al);
			s3 = ah;

			ah = c;
			ah = (byte) (ah & 0x3f);
			s4 = ah;

			byte[] tmp = new byte[4];
			tmp[0] = cBase64.getBytes()[s1];
			tmp[1] = cBase64.getBytes()[s2];
			tmp[2] = cBase64.getBytes()[s3];
			tmp[3] = cBase64.getBytes()[s4];
			ret = arraycat(ret, tmp);
		}

		return new String(ret);
	}
	
	/**
	 * 解密
	 * @param strSour
	 * @return
	 */
	public static String decode64(String strSour) {
		byte a, b, c;
		byte s1, s2, s3, s4;
		int i;
		String ret = "";
		if (strSour.length() % 4 == 0) {
			byte ah = 0;
			byte al = 0;

			for (i = 0; i < strSour.length() / 4; i++) {
				s1 = (byte) (cBase64.indexOf(strSour.getBytes()[i * 4 + 0]) - 0);
				s2 = (byte) (cBase64.indexOf(strSour.getBytes()[i * 4 + 1]) - 0);
				s3 = (byte) (cBase64.indexOf(strSour.getBytes()[i * 4 + 2]) - 0);
				s4 = (byte) (cBase64.indexOf(strSour.getBytes()[i * 4 + 3]) - 0);
				
				ah = s1;
				al = s2;
				ah = (byte) (ah << 2);
				al = (byte) (al >> 4);
				ah = (byte) (ah | al);
				a = ah;
				
				ah = s2;
				al = s3;
				ah = (byte) (ah << 4);
				al = (byte) (al >> 2);
				al = (byte) (al & 0x0f);
				ah = (byte) (ah | al);
				b = ah;

				ah = s3;
				al = s4;
				ah = (byte) (ah << 6);
				ah = (byte) (ah | al);
				c = ah;

				byte[] tmp = new byte[3];
				tmp[0] = a;
				tmp[1] = b;
				tmp[2] = c;
				
				ret = ret + new String(tmp);
			}
		}
		ret = decodeUnicode(ret).trim();
		return ret;
	}
	
	/**
	 * 合并数组
	 * @param buf1
	 * @param buf2
	 * @return
	 */
	public static byte[] arraycat(byte[] buf1, byte[] buf2) {
		byte[] bufret = null;
		int len1 = 0;
		int len2 = 0;
		if (buf1 != null)
			len1 = buf1.length;
		if (buf2 != null)
			len2 = buf2.length;
		if (len1 + len2 > 0)
			bufret = new byte[len1 + len2];
		if (len1 > 0)
			System.arraycopy(buf1, 0, bufret, 0, len1);
		if (len2 > 0)
			System.arraycopy(buf2, 0, bufret, len1, len2);
		return bufret;
	}

	/**
	 * 中文转换成unicode
	 * 
	 * @param str
	 * @return
	 */
	public static String chinaToUnicode(String str) {
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			int chr1 = (char) str.charAt(i);
			if (chr1 >= 19968 && chr1 <= 171941) {// 汉字范围 \u4e00-\u9fa5 (中文)
				result += "\\u" + Integer.toHexString(chr1);
			} else {
				result += str.charAt(i);
			}
		}
		return result;
	}

	/**
	 * unicode转换成中文
	 * 
	 * @param theString
	 * @return
	 */
	public static String decodeUnicode(String theString) {
		char aChar;
		int len = theString.length();
		StringBuffer outBuffer = new StringBuffer(len);
		for (int x = 0; x < len;) {
			aChar = theString.charAt(x++);
			if (aChar == '\\') {
				aChar = theString.charAt(x++);
				if (aChar == 'u') {
					// Read the xxxx
					int value = 0;
					for (int i = 0; i < 4; i++) {
						aChar = theString.charAt(x++);
						switch (aChar) {
						case '0':
						case '1':
						case '2':
						case '3':
						case '4':
						case '5':
						case '6':
						case '7':
						case '8':
						case '9':
							value = (value << 4) + aChar - '0';
							break;
						case 'a':
						case 'b':
						case 'c':
						case 'd':
						case 'e':
						case 'f':
							value = (value << 4) + 10 + aChar - 'a';
							break;
						case 'A':
						case 'B':
						case 'C':
						case 'D':
						case 'E':
						case 'F':
							value = (value << 4) + 10 + aChar - 'A';
							break;
						default:
							throw new IllegalArgumentException(
									"Malformed   \\uxxxx   encoding.");
						}
					}
					outBuffer.append((char) value);
				} else {
					if (aChar == 't')
						aChar = '\t';
					else if (aChar == 'r')
						aChar = '\r';
					else if (aChar == 'n')
						aChar = '\n';
					else if (aChar == 'f')
						aChar = '\f';
					outBuffer.append(aChar);
				}
			} else
				outBuffer.append(aChar);
		}
		return outBuffer.toString();
	}

	
}
