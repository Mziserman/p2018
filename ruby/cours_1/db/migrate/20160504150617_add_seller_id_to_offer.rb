class AddSellerIdToOffer < ActiveRecord::Migration
  def change
    add_column :offers, :id, :integer
  end
end
