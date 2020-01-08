package br.com.intraPRO.util;

import java.util.Date;
import java.util.Vector;

public class QSortAlgorithm {

	private String nomeItem;

	private void quickSort(Vector vector, int lo0, int hi0) throws Exception {
		int lo = lo0;
		int hi = hi0;
		Object mid;
		Class TYPEPARAMS[] = {
		};
		Object ARGS[] = {
		};

		if (hi0 > lo0) {

			mid = vector.elementAt((lo0 + hi0) / 2);

			while (lo <= hi) {
				while ((lo < hi0) && (Integer.parseInt(vector.elementAt(lo).getClass().getMethod(getMetodo(), TYPEPARAMS).invoke(vector.elementAt(lo), ARGS).toString()) < Integer.parseInt(mid.getClass().getMethod(getMetodo(), TYPEPARAMS).invoke(mid, ARGS).toString())))
					++lo;
				while ((hi > lo0) && (Integer.parseInt(vector.elementAt(hi).getClass().getMethod(getMetodo(), TYPEPARAMS).invoke(vector.elementAt(hi), ARGS).toString()) > Integer.parseInt(mid.getClass().getMethod(getMetodo(), TYPEPARAMS).invoke(mid, ARGS).toString())))
					--hi;

				if (lo <= hi) {
					swap(vector, lo, hi);
					++lo;
					--hi;
				}
			}

			if (lo0 < hi)
				quickSort(vector, lo0, hi);

			if (lo < hi0)
				quickSort(vector, lo, hi0);
		}
	}

	private void quickSortString(Vector vector, int lo0, int hi0) throws Exception {
		int lo = lo0;
		int hi = hi0;
		Object mid;
		Class TYPEPARAMS[] = {
		};
		Object ARGS[] = {
		};

		if (hi0 > lo0) {

			mid = vector.elementAt((lo0 + hi0) / 2);

			while (lo <= hi) {
				while ((lo < hi0) && (vector.elementAt(lo).getClass().getMethod(getMetodo(), TYPEPARAMS).invoke(vector.elementAt(lo), ARGS).toString().toUpperCase().compareTo(mid.getClass().getMethod(getMetodo(), TYPEPARAMS).invoke(mid, ARGS).toString().toUpperCase())) < 0)
					++lo;
				while ((hi > lo0) && (vector.elementAt(hi).getClass().getMethod(getMetodo(), TYPEPARAMS).invoke(vector.elementAt(hi), ARGS).toString().toUpperCase().compareTo(mid.getClass().getMethod(getMetodo(), TYPEPARAMS).invoke(mid, ARGS).toString().toUpperCase())) > 0)
					--hi;

				if (lo <= hi) {
					swap(vector, lo, hi);
					++lo;
					--hi;
				}
			}

			if (lo0 < hi)
				quickSortString(vector, lo0, hi);

			if (lo < hi0)
				quickSortString(vector, lo, hi0);
		}
	}

	private void quickSortDate(Vector vector, int lo0, int hi0) throws Exception {
		int lo = lo0;
		int hi = hi0;
		Object mid;
		Class TYPEPARAMS[] = {
		};
		Object ARGS[] = {
		};

		if (hi0 > lo0) {

			mid = vector.elementAt((lo0 + hi0) / 2);

			while (lo <= hi) {
				while ((lo < hi0) && (((Date) vector.elementAt(lo).getClass().getMethod(getMetodo(), TYPEPARAMS).invoke(vector.elementAt(lo), ARGS)).getTime() < ((Date) mid.getClass().getMethod(getMetodo(), TYPEPARAMS).invoke(mid, ARGS)).getTime()))
					++lo;
				while ((hi > lo0) && (((Date) vector.elementAt(hi).getClass().getMethod(getMetodo(), TYPEPARAMS).invoke(vector.elementAt(hi), ARGS)).getTime() > ((Date) mid.getClass().getMethod(getMetodo(), TYPEPARAMS).invoke(mid, ARGS)).getTime()))
					--hi;

				if (lo <= hi) {
					swap(vector, lo, hi);
					++lo;
					--hi;
				}
			}

			if (lo0 < hi)
				quickSortDate(vector, lo0, hi);

			if (lo < hi0)
				quickSortDate(vector, lo, hi0);
		}
	}

	/**
		 * @param vector
		 * @param i
		 * @param j
		 */
	/*private void quickSortNested(Vector vector, int lo0, int hi0) throws Exception {
		BeanUtil beanUtils = new BeanUtil();
		int lo = lo0;
		int hi = hi0;
		Object mid;
		Class TYPEPARAMS[] = {
		};
		Object ARGS[] = {
		};

		if (hi0 > lo0) {

			mid = vector.elementAt((lo0 + hi0) / 2);

			while (lo <= hi) {
				while ((lo < hi0) && (beanUtils.getProperty(vector.elementAt(lo), this.nomeItem).toUpperCase().compareTo(beanUtils.getProperty(mid, this.nomeItem).toUpperCase())) < 0)
					++lo;
				while ((hi > lo0) && (beanUtils.getProperty(vector.elementAt(hi), this.nomeItem).toUpperCase().compareTo(beanUtils.getProperty(mid, this.nomeItem).toUpperCase())) > 0)
					--hi;

				if (lo <= hi) {
					swap(vector, lo, hi);
					++lo;
					--hi;
				}
			}

			if (lo0 < hi)
				quickSortNested(vector, lo0, hi);

			if (lo < hi0)
				quickSortNested(vector, lo, hi0);
		}
	}*/

	public void sortInt(Vector vector, String nomeItem) throws Exception {
		this.nomeItem = nomeItem;
		quickSort(vector, 0, vector.size() - 1);
	}

	public void sortString(Vector vector, String nomeItem) throws Exception {
		this.nomeItem = nomeItem;
		quickSortString(vector, 0, vector.size() - 1);
	}

	public void sortDate(Vector vector, String nomeItem) throws Exception {
		this.nomeItem = nomeItem;
		quickSortDate(vector, 0, vector.size() - 1);
	}

	public void sortByNestedPropertyAsString(Vector vector, String nomeItem) throws Exception {
		this.nomeItem = nomeItem;
		//quickSortNested(vector, 0, vector.size() - 1);
	}

	private String getMetodo() {
		return "get" + this.nomeItem.substring(0, 1).toUpperCase() + this.nomeItem.substring(1);
	}

	@SuppressWarnings("unchecked")
	private void swap(Vector vector, int i, int j) {
		Object T;
		T = vector.elementAt(i);
		vector.insertElementAt(vector.elementAt(j), i);
		vector.removeElementAt(i + 1);
		vector.insertElementAt(T, j);
		vector.removeElementAt(j + 1);
	}

}
