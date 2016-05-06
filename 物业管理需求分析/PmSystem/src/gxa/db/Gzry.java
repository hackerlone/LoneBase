package gxa.db;

import java.sql.Timestamp;
	public class Gzry implements java.io.Serializable {
		private String gz_bianhao; 		
		private String w_id; 		
		private String gz_qk; 		
		private String gz_nb;
		public Gzry() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "Gzry [gz_bianhao=" + gz_bianhao + ", w_id=" + w_id
					+ ", gz_qk=" + gz_qk + ", gz_nb=" + gz_nb + "]";
		}
		public String getGz_bianhao() {
			return gz_bianhao;
		}
		public void setGz_bianhao(String gz_bianhao) {
			this.gz_bianhao = gz_bianhao;
		}
		public String getW_id() {
			return w_id;
		}
		public void setW_id(String w_id) {
			this.w_id = w_id;
		}
		public String getGz_qk() {
			return gz_qk;
		}
		public void setGz_qk(String gz_qk) {
			this.gz_qk = gz_qk;
		}
		public String getGz_nb() {
			return gz_nb;
		}
		public void setGz_nb(String gz_nb) {
			this.gz_nb = gz_nb;
		} 		
		
}
