json.array!(@sellers) do |seller|
  json.extract! seller, :id, :name, :rate
  json.url seller_url(seller, format: :json)
end
