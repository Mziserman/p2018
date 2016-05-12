class AddSellerIdToOffer < ActiveRecord::Migration
  def change
    add_column :offers, :seller_id, :integer
  end
end
