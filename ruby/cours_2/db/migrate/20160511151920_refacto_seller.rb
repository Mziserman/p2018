class RefactoSeller < ActiveRecord::Migration
  def change

  	add_column( :sellers, :email, :string )
  	remove_column( :sellers, :description, :text ) #le dernier param est optionnel mais si on ne le mets pas on ne pourra pas rollback
  	remove_column( :sellers, :lastname, :string ) #le dernier param est optionnel mais si on ne le mets pas on ne pourra pas rollback
  	rename_column( :sellers, :firstname, :name ) 

  end
  
  # def up #sens normale
  # 	change_column( :sellers, :rate, :integer) #irreversible
  # end

  # def down #rollback
  # end
end
