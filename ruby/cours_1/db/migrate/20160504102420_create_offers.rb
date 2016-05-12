class CreateOffers < ActiveRecord::Migration
  def change
    create_table :offers do |t|
      t.text :title
      t.text :description
      t.datetime :activated_at

      t.timestamps null: false
    end
  end
end
