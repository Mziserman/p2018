class CreateSellers < ActiveRecord::Migration
  def change
    create_table :sellers do |t|
      t.string :firstname
      t.string :lastname
      t.decimal :rate
      t.text :description

      t.timestamps null: false
    end
  end
end
