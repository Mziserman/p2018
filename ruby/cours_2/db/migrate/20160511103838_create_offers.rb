class CreateOffers < ActiveRecord::Migration
  def change
    create_table :offers do |t|
      t.string :title, null: false
      t.text :description, null: false
      t.datetime :published_at, default: nil
      t.decimal :price, default: 0, null: false

      t.timestamps null: false
    end
  end
end
