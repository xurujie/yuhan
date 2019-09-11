package com.yuhan.entities;

import java.sql.Timestamp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;
import lombok.Data;
import lombok.experimental.Accessors;


@Data
/*@AllArgsConstructor
@NoArgsConstructor*/
@Accessors(chain = true)
public class UserInformation {
	@JsonSerialize(include=Inclusion.NON_EMPTY)
	private int id;
	@JsonSerialize(include=Inclusion.NON_EMPTY)
	private String user_name;
	@JsonSerialize(include=Inclusion.NON_EMPTY)
	private String pass_word;
	@JsonSerialize(include=Inclusion.NON_EMPTY)
	private String taobao_name;
	@JsonSerialize(include=Inclusion.NON_EMPTY)
	private String user_img;
	@JsonSerialize(include=Inclusion.NON_EMPTY)
	private String birthday;
	@JsonSerialize(include=Inclusion.NON_EMPTY)
	private String gender;
	@JsonSerialize(include=Inclusion.NON_EMPTY)
	private String tel;
	@JsonSerialize(include=Inclusion.NON_EMPTY)
	private String yuchong_vip;
	@JsonSerialize(include=Inclusion.NON_EMPTY)
	private String balance_account;
	@JsonSerialize(include=Inclusion.NON_EMPTY)
	private String refund;
	@JsonSerialize(include=Inclusion.NON_EMPTY)
	private String account_integral;
	@JsonSerialize(include=Inclusion.NON_EMPTY)
	private String discount_id;
	@JsonSerialize(include=Inclusion.NON_EMPTY)
	private String shopping_id;
	@JsonSerialize(include=Inclusion.NON_EMPTY)
	private String favoritesinformation_id;
	@JsonSerialize(include=Inclusion.NON_EMPTY)
	private String payment_id;
	@JsonSerialize(include=Inclusion.NON_EMPTY)
	private String receiving_id;
	@JsonSerialize(include=Inclusion.NON_EMPTY)
	private String accomplish_id;
	@JsonSerialize(include=Inclusion.NON_EMPTY)
	private String site_id;
	@JsonSerialize(include=Inclusion.NON_EMPTY)
	private Timestamp register_time;
	@JsonSerialize(include=Inclusion.NON_EMPTY)
	private int new_man;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accomplish_id == null) ? 0 : accomplish_id.hashCode());
		result = prime * result + ((account_integral == null) ? 0 : account_integral.hashCode());
		result = prime * result + ((balance_account == null) ? 0 : balance_account.hashCode());
		result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result + ((discount_id == null) ? 0 : discount_id.hashCode());
		result = prime * result + ((favoritesinformation_id == null) ? 0 : favoritesinformation_id.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + id;
		result = prime * result + new_man;
		result = prime * result + ((pass_word == null) ? 0 : pass_word.hashCode());
		result = prime * result + ((payment_id == null) ? 0 : payment_id.hashCode());
		result = prime * result + ((receiving_id == null) ? 0 : receiving_id.hashCode());
		result = prime * result + ((refund == null) ? 0 : refund.hashCode());
		result = prime * result + ((register_time == null) ? 0 : register_time.hashCode());
		result = prime * result + ((shopping_id == null) ? 0 : shopping_id.hashCode());
		result = prime * result + ((site_id == null) ? 0 : site_id.hashCode());
		result = prime * result + ((taobao_name == null) ? 0 : taobao_name.hashCode());
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
		result = prime * result + ((user_img == null) ? 0 : user_img.hashCode());
		result = prime * result + ((user_name == null) ? 0 : user_name.hashCode());
		result = prime * result + ((yuchong_vip == null) ? 0 : yuchong_vip.hashCode());
		return result;
	}
	public UserInformation(int id, String user_name, String pass_word, String taobao_name, String user_img,
			String birthday, String gender, String tel, String yuchong_vip, String balance_account, String refund,
			String account_integral, String discount_id, String shopping_id, String favoritesinformation_id,
			String payment_id, String receiving_id, String accomplish_id, String site_id, Timestamp register_time,
			int new_man) {
		super();
		this.id = id;
		this.user_name = user_name;
		this.pass_word = pass_word;
		this.taobao_name = taobao_name;
		this.user_img = user_img;
		this.birthday = birthday;
		this.gender = gender;
		this.tel = tel;
		this.yuchong_vip = yuchong_vip;
		this.balance_account = balance_account;
		this.refund = refund;
		this.account_integral = account_integral;
		this.discount_id = discount_id;
		this.shopping_id = shopping_id;
		this.favoritesinformation_id = favoritesinformation_id;
		this.payment_id = payment_id;
		this.receiving_id = receiving_id;
		this.accomplish_id = accomplish_id;
		this.site_id = site_id;
		this.register_time = register_time;
		this.new_man = new_man;
	}
	public UserInformation() {
		super();
	}
	public UserInformation(String user_name, String pass_word, String taobao_name, String user_img, String birthday,
			String gender, String tel, String yuchong_vip, String balance_account, String refund,
			String account_integral, String discount_id, String shopping_id, String favoritesinformation_id,
			String payment_id, String receiving_id, String accomplish_id, String site_id, Timestamp register_time,
			int new_man) {
		super();
		this.user_name = user_name;
		this.pass_word = pass_word;
		this.taobao_name = taobao_name;
		this.user_img = user_img;
		this.birthday = birthday;
		this.gender = gender;
		this.tel = tel;
		this.yuchong_vip = yuchong_vip;
		this.balance_account = balance_account;
		this.refund = refund;
		this.account_integral = account_integral;
		this.discount_id = discount_id;
		this.shopping_id = shopping_id;
		this.favoritesinformation_id = favoritesinformation_id;
		this.payment_id = payment_id;
		this.receiving_id = receiving_id;
		this.accomplish_id = accomplish_id;
		this.site_id = site_id;
		this.register_time = register_time;
		this.new_man = new_man;
	}
	@Override
	public String toString() {
		return "\"UserInformation\": {\"id\":\"" + id + "\", \"user_name\":\"" + user_name + "\", \"pass_word\":\"" + pass_word + "\", \"taobao_name\":\""
				+ taobao_name + "\", \"user_img\":\"" + user_img + "\", \"birthday\":\"" + birthday + "\", \"gender\":\"" + gender + "\", \"tel\":\""
				+ tel + "\",\"yuchong_vip\":\"" + yuchong_vip + "\",\"balance_account\":\"" + balance_account + "\", \"refund\":\"" + refund
				+ "\", \"account_integral\":\"" + account_integral + "\", \"discount_id\":\"" + discount_id + "\", \"shopping_id\":\""
				+ shopping_id + "\", \"favoritesinformation_id\":\"" + favoritesinformation_id + "\", \"payment_id\":\"" + payment_id
				+ "\", \"receiving_id\":\"" + receiving_id + "\", \"accomplish_id\":\"" + accomplish_id + "\", \"site_id\":\"" + site_id
				+ "\", \"register_time\":\"" + register_time + "\", \"new_man\":\"" + new_man + "\"}";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserInformation other = (UserInformation) obj;
		if (accomplish_id == null) {
			if (other.accomplish_id != null)
				return false;
		} else if (!accomplish_id.equals(other.accomplish_id))
			return false;
		if (account_integral == null) {
			if (other.account_integral != null)
				return false;
		} else if (!account_integral.equals(other.account_integral))
			return false;
		if (balance_account == null) {
			if (other.balance_account != null)
				return false;
		} else if (!balance_account.equals(other.balance_account))
			return false;
		if (birthday == null) {
			if (other.birthday != null)
				return false;
		} else if (!birthday.equals(other.birthday))
			return false;
		if (discount_id == null) {
			if (other.discount_id != null)
				return false;
		} else if (!discount_id.equals(other.discount_id))
			return false;
		if (favoritesinformation_id == null) {
			if (other.favoritesinformation_id != null)
				return false;
		} else if (!favoritesinformation_id.equals(other.favoritesinformation_id))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (id != other.id)
			return false;
		if (new_man != other.new_man)
			return false;
		if (pass_word == null) {
			if (other.pass_word != null)
				return false;
		} else if (!pass_word.equals(other.pass_word))
			return false;
		if (payment_id == null) {
			if (other.payment_id != null)
				return false;
		} else if (!payment_id.equals(other.payment_id))
			return false;
		if (receiving_id == null) {
			if (other.receiving_id != null)
				return false;
		} else if (!receiving_id.equals(other.receiving_id))
			return false;
		if (refund == null) {
			if (other.refund != null)
				return false;
		} else if (!refund.equals(other.refund))
			return false;
		if (register_time == null) {
			if (other.register_time != null)
				return false;
		} else if (!register_time.equals(other.register_time))
			return false;
		if (shopping_id == null) {
			if (other.shopping_id != null)
				return false;
		} else if (!shopping_id.equals(other.shopping_id))
			return false;
		if (site_id == null) {
			if (other.site_id != null)
				return false;
		} else if (!site_id.equals(other.site_id))
			return false;
		if (taobao_name == null) {
			if (other.taobao_name != null)
				return false;
		} else if (!taobao_name.equals(other.taobao_name))
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		if (user_img == null) {
			if (other.user_img != null)
				return false;
		} else if (!user_img.equals(other.user_img))
			return false;
		if (user_name == null) {
			if (other.user_name != null)
				return false;
		} else if (!user_name.equals(other.user_name))
			return false;
		if (yuchong_vip == null) {
			if (other.yuchong_vip != null)
				return false;
		} else if (!yuchong_vip.equals(other.yuchong_vip))
			return false;
		return true;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPass_word() {
		return pass_word;
	}
	public void setPass_word(String pass_word) {
		this.pass_word = pass_word;
	}
	public String getTaobao_name() {
		return taobao_name;
	}
	public void setTaobao_name(String taobao_name) {
		this.taobao_name = taobao_name;
	}
	public String getUser_img() {
		return user_img;
	}
	public void setUser_img(String user_img) {
		this.user_img = user_img;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getYuchong_vip() {
		return yuchong_vip;
	}
	public void setYuchong_vip(String yuchong_vip) {
		this.yuchong_vip = yuchong_vip;
	}
	public String getBalance_account() {
		return balance_account;
	}
	public void setBalance_account(String balance_account) {
		this.balance_account = balance_account;
	}
	public String getRefund() {
		return refund;
	}
	public void setRefund(String refund) {
		this.refund = refund;
	}
	public String getAccount_integral() {
		return account_integral;
	}
	public void setAccount_integral(String account_integral) {
		this.account_integral = account_integral;
	}
	public String getDiscount_id() {
		return discount_id;
	}
	public void setDiscount_id(String discount_id) {
		this.discount_id = discount_id;
	}
	public String getShopping_id() {
		return shopping_id;
	}
	public void setShopping_id(String shopping_id) {
		this.shopping_id = shopping_id;
	}
	public String getFavoritesinformation_id() {
		return favoritesinformation_id;
	}
	public void setFavoritesinformation_id(String favoritesinformation_id) {
		this.favoritesinformation_id = favoritesinformation_id;
	}
	public String getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(String payment_id) {
		this.payment_id = payment_id;
	}
	public String getReceiving_id() {
		return receiving_id;
	}
	public void setReceiving_id(String receiving_id) {
		this.receiving_id = receiving_id;
	}
	public String getAccomplish_id() {
		return accomplish_id;
	}
	public void setAccomplish_id(String accomplish_id) {
		this.accomplish_id = accomplish_id;
	}
	public String getSite_id() {
		return site_id;
	}
	public void setSite_id(String site_id) {
		this.site_id = site_id;
	}
	public Timestamp getRegister_time() {
		return register_time;
	}
	public void setRegister_time(Timestamp register_time) {
		this.register_time = register_time;
	}
	public int getNew_man() {
		return new_man;
	}
	public void setNew_man(int new_man) {
		this.new_man = new_man;
	}

	
	
	
}
